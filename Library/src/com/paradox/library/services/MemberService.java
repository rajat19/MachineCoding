package com.paradox.library.services;

import com.paradox.library.models.BookLending;
import com.paradox.library.models.BookReservation;
import com.paradox.library.models.Constants;
import com.paradox.library.models.Fine;
import com.paradox.library.models.account.Member;
import com.paradox.library.models.book.BookItem;
import com.paradox.library.models.enums.BookStatus;
import com.paradox.library.models.enums.ReservationStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MemberService {
    private Map<String, Member> memberMap;
    private BookReservationService bookReservationService;

    private MemberService() {
        memberMap = new HashMap<>();
        bookReservationService = BookReservationService.getInstance();
    }

    public boolean checkoutBookItem(Member member, BookItem bookItem) {
        if (member.getTotalBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            throw new Error("The user has already checked-out maximum number of books");
        }
        BookReservation bookReservation = bookReservationService.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null && !bookReservation.getMemberId().equals(member.getId())) {
            // book item has a pending reservation from another user
            throw new Error("This book is reserved by another member");
        } else if (bookReservation != null) {
            // book item has a pending reservation from the give member, update it
            bookReservation.setStatus(ReservationStatus.COMPLETED);
        }

        if (!bookItem.checkout(member.getId())) {
            return false;
        }

        member.incrementTotalBooksCheckedOut();
        return true;
    }

    private void checkForFine(Member member, String bookItemBarcode) {
        BookLending bookLending = bookReservationService.fetchLendingDetails(bookItemBarcode);
        Date dueDate = bookLending.getDueDate();
        Date today = new Date();
        // check if the book has been returned within the due date
        if (today.compareTo(dueDate) > 0) {
            long diff = today.getTime() - dueDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            Fine.collectFine(member.getId(), diffDays);
        }
    }

    public void returnBookItem(Member member, BookItem bookItem) {
        checkForFine(member, bookItem.getBarcode());
        BookReservation bookReservation = bookReservationService.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null) {
            // book item has a pending reservation
            bookItem.setStatus(BookStatus.RESERVED);
//            bookReservation.sendBookAvailableNotification();
        }
        bookItem.setStatus(BookStatus.AVAILABLE);
    }

    public boolean renewBookItem(Member member, BookItem bookItem) {
        checkForFine(member, bookItem.getBarcode());
        BookReservation bookReservation = bookReservationService.fetchReservationDetails(bookItem.getBarcode());
        // check if this book item has a pending reservation from another member
        if (bookReservation != null && !bookReservation.getMemberId().equals(member.getId())) {
//            member.decrementTotalBooksCheckedout();
            bookItem.setStatus(BookStatus.RESERVED);
//            bookReservation.sendBookAvailableNotification();
            throw new Error("This book is reserved by another member");
        } else if (bookReservation != null) {
            // book item has a pending reservation from this member
            bookReservation.setStatus(ReservationStatus.COMPLETED);
        }
        bookReservationService.lendBook(bookItem.getBarcode(), member.getId());
        bookItem.setDueDate(new Date(String.valueOf(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS))));
        return true;
    }
}
