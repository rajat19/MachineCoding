package com.paradox.restaurant.models;

import com.paradox.restaurant.models.enums.TableStatus;

public class Table {
    private int id;
    private TableStatus status;
    private int maxCapacity;
    private Reservation reservation;

    public Table(int id, int maxCapacity) {
        this.id = id;
        this.status = TableStatus.FREE;
        this.maxCapacity = maxCapacity;
    }

    public boolean isTableFree() {
        return status == TableStatus.FREE;
    }

    public void markTableFree() {
        this.status = TableStatus.FREE;
        this.reservation = null;
    }

    public void addReservation(Reservation reservation) {
        this.reservation = reservation;
        this.status = TableStatus.OCCUPIED;
    }
}
