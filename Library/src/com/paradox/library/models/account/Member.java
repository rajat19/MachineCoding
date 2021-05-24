package com.paradox.library.models.account;

import com.paradox.library.models.BookLending;
import com.paradox.library.models.BookReservation;
import com.paradox.library.models.book.BookItem;
import com.paradox.library.models.enums.BookStatus;
import com.paradox.library.models.enums.ReservationStatus;

import java.time.LocalDate;
import java.util.Date;

public class Member extends Account {
    private Date dateOfMembership;
    private int totalBooksCheckedOut;

    public int getTotalBooksCheckedOut() {
        return totalBooksCheckedOut;
    }

    public void reserveBookItem(BookItem bookItem) {
        bookItem.checkout(this.getId());
    }

    public void incrementTotalBooksCheckedOut() {
        this.totalBooksCheckedOut++;
    }

    @Override
    public void resetPassword(String newPassword) {
        this.setPassword(newPassword);
    }
}
