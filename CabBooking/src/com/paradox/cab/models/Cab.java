package com.paradox.cab.models;

public class Cab {
    private final String id;
    private final String driverName;
    private boolean isAvailable;
    private Trip currentTrip;
    private Location currentLocation;

    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getDriverName() {
        return driverName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id='" + id + '\'' +
                ", driverName='" + driverName + '\'' +
                ", isAvailable=" + isAvailable +
                ", currentTrip=" + currentTrip +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
