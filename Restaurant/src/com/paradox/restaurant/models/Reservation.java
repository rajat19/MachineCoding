package com.paradox.restaurant.models;

import com.paradox.restaurant.models.accounts.Customer;
import com.paradox.restaurant.models.enums.ReservationStatus;

import java.util.Date;
import java.util.List;

public class Reservation {
    private String reservationId;
    private Date timeOfReservation;
    private int peopleCount;
    private ReservationStatus status;
    private String notes;
    private Date checkinTime;
    private Customer customer;
    private List<Table> tables;

    public Reservation(Customer customer, List<Table> tables, Date checkinTime, Date timeOfReservation) {
        this.reservationId = customer + "_" + checkinTime + "_" + timeOfReservation;
        this.customer = customer;
        this.tables = tables;
        this.checkinTime = checkinTime;
        this.timeOfReservation = timeOfReservation;
        this.status = ReservationStatus.CONFIRMED;
    }

    public void updatePeopleCount(int count) {

    }

    public String getReservationId() {
        return reservationId;
    }

    public Date getTimeOfReservation() {
        return timeOfReservation;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Table> getTables() {
        return tables;
    }
}
