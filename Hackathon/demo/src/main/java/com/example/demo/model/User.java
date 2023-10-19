package com.example.demo.model;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    private double latitude;
    private double longitude;
    private int vehicleCapacity;

    public User(int id, String firstName, String lastName, double latitude, double longitude, int vehicleCapacity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicleCapacity = vehicleCapacity;
    }

    @Override
    public String toString() {
        return "User " + id + " (Name: " + firstName + " " + lastName +
                ", Lat: " + latitude + ", Lon: " + longitude + ", Vehicle Capacity: " + vehicleCapacity + ")";
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public double getDistanceTo(User otherUser) {
        double earthRadius = 6371.0; // Earth radius in kilometers
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(otherUser.latitude);
        double lon2 = Math.toRadians(otherUser.longitude);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setVehicleCapacity(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

}
