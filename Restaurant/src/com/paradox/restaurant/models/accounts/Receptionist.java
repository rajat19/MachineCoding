package com.paradox.restaurant.models.accounts;

import com.paradox.restaurant.models.Reservation;
import com.paradox.restaurant.models.Table;

import java.util.Date;
import java.util.List;

public class Receptionist extends Employee{
    public Receptionist(String name, String email, String phone, int employeeId, Date dateJoined) {
        super(name, email, phone, employeeId, dateJoined);
    }

    public void createReservation(Customer customer, int tablesCount, Date bookingTime) {
        List<Table> freeTables = this.getRestaurant().getFreeTables(bookingTime);
        if (freeTables.size() == 0 || freeTables.size() < tablesCount) {
            registerWaitList(customer);
            return;
        }
        List<Table> tables = freeTables.subList(0, tablesCount);

        Reservation reservation = new Reservation(customer, tables, bookingTime, new Date(System.currentTimeMillis()));
        tables.forEach(table -> table.addReservation(reservation));
        this.getRestaurant().addReservation(reservation);
    }

    public void registerWaitList(Customer customer) {
        this.getRestaurant().addWaitlist(customer);
    }

    public void clearReservation(Reservation reservation) {
        this.getRestaurant().removeReservation(reservation);
        List<Table> reservedTables = reservation.getTables();
        reservedTables.forEach(t -> t.markTableFree());
        this.getRestaurant().notifyCustomers();
    }
}
