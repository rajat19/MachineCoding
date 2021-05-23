package com.paradox.cab.models;

import com.paradox.cab.models.enums.TripStatus;

public class Trip {
    private final Rider rider;
    private final Cab cab;
    private TripStatus tripStatus;
    private final double price;
    private final Location from;
    private final Location to;

    public Trip(Rider rider, Cab cab, double price, Location from, Location to) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.from = from;
        this.to = to;
        this.tripStatus = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.tripStatus = TripStatus.FINISHED;
    }

    public void cancelTrip() {
        this.tripStatus = TripStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "rider=" + rider.getId() +
                ", cab=" + cab.getId() +
                ", tripStatus=" + tripStatus +
                ", price=" + price +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
