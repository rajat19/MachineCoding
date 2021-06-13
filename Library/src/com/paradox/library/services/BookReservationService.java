package com.paradox.library.services;

import com.paradox.library.models.BookLending;
import com.paradox.library.models.BookReservation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BookReservationService {
    private final Map<String, BookReservation> bookReservationMap;
    private final Map<String, BookLending> bookLendingMap;
    private static BookReservationService instance;

    private BookReservationService() {
        bookReservationMap = new HashMap<>();
        bookLendingMap = new HashMap<>();
    }

    public static BookReservationService getInstance() {
        if (instance == null) {
            synchronized (BookReservationService.class) {
                if (instance == null) {
                    instance = new BookReservationService();
                }
            }
        }
        return instance;
    }

    public BookReservation fetchReservationDetails(String barcode) {
        if (!bookReservationMap.containsKey(barcode)) {
            return null;
        }
        return bookReservationMap.get(barcode);
    }

    public void lendBook(String barcode, String memberId) {
        Date creationDate = new Date();
    }
    public BookLending fetchLendingDetails(String barcode) {

    }
}
