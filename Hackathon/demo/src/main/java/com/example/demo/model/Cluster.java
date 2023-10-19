package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private List<User> users = new ArrayList<>();
    private int carCapacity;
    private int totalCapacity;
    private double latitudeSum;
    private double longitudeSum;

    public Cluster(int carCapacity) {
        this.carCapacity = carCapacity;
        this.totalCapacity = 0;
        this.latitudeSum = 0;
        this.longitudeSum = 0;
    }

    public boolean canAddUser(User user) {
        return users.size() < carCapacity && totalCapacity + user.getVehicleCapacity() <= carCapacity;
    }

    public void addUser(User user) {
        users.add(user);
        totalCapacity += user.getVehicleCapacity();
        latitudeSum += user.getLatitude();
        longitudeSum += user.getLongitude();
    }

    public User getCenter() {
        double centerLatitude = latitudeSum / users.size();
        double centerLongitude = longitudeSum / users.size();
        return new User(0, "Center", "Point", centerLatitude, centerLongitude, 0);
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public double getLatitudeSum() {
        return latitudeSum;
    }

    public void setLatitudeSum(double latitudeSum) {
        this.latitudeSum = latitudeSum;
    }

    public double getLongitudeSum() {
        return longitudeSum;
    }

    public void setLongitudeSum(double longitudeSum) {
        this.longitudeSum = longitudeSum;
    }
}
