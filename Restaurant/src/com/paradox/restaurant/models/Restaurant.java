package com.paradox.restaurant.models;

import com.paradox.restaurant.models.accounts.Customer;
import com.paradox.restaurant.models.accounts.Employee;
import com.paradox.restaurant.models.enums.ReservationStatus;

import java.util.*;

public class Restaurant {
    private final String name;
    private final String registrationNumber;
    private final List<Employee> employees;
    private final Kitchen kitchen;
    private final List<Table> tables;
    private final List<Reservation> activeReservations;
    private final List<Customer> waitlist;

    public Restaurant(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.employees = new ArrayList<>();
        this.kitchen = new Kitchen(name);
        this.tables = new ArrayList<>();
        this.activeReservations = new ArrayList<>();
        this.waitlist = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<Reservation> getActiveReservations() {
        return activeReservations;
    }

    public List<Customer> getWaitlist() {
        return waitlist;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void addTables(Table table) {
        this.tables.add(table);
    }

    public void addReservation(Reservation reservation) {
        this.activeReservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        this.activeReservations.remove(reservation);
    }

    public void addWaitlist(Customer customer) {
        this.waitlist.add(customer);
    }

    public void removeFromWaitlist(Customer customer) {
        this.waitlist.remove(customer);
    }

    public void notifyCustomers() {
        
    }

    public List<Table> getBookedTables(Date bookingTime) {
        List<Table> bookedTables = new ArrayList<>();
        for (Reservation reservation: activeReservations) {
            Date start = reservation.getCheckinTime();
            Date end = new Date(reservation.getCheckinTime().getTime() + 1000*60*60*2);
            if (reservation.getStatus() == ReservationStatus.CONFIRMED &&
                start.before(bookingTime) && end.after(bookingTime)) {
                bookedTables.addAll(reservation.getTables());
            }
        }
        return bookedTables;
    }

    public List<Table> getFreeTables(Date bookingTime) {
        List<Table> tables = this.tables;
        List<Table> bookedTables = getBookedTables(bookingTime);
        Set<Table> bookedTablesSet = new HashSet<>(bookedTables);
        tables.removeIf(bookedTablesSet::contains);
        return tables;
    }
}
