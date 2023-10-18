package org.example;

import java.util.ArrayList;
import java.util.List;

public class CarSharingClusteringV12 {
    public static void main(String[] args) {
        // Sample user data with location, vehicle capacity, first name, and last name
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", "Doe", 40.7128, -74.0060, 3));
        users.add(new User(2, "Alice", "Smith", 34.0522, -118.2437, 4));
        users.add(new User(3, "Bob", "Johnson", 51.5074, -0.1278, 0));
        users.add(new User(4, "Emily", "Brown", 48.8566, 2.3522, 4));
        users.add(new User(5, "Michael", "Wilson", 34.0522, -118.2437, 4));
        users.add(new User(6, "Sophia", "Lee", 40.7128, -74.0060, 0));
        users.add(new User(7, "Daniel", "Davis", 51.5099, -0.1337, 0));
        users.add(new User(8, "Emma", "Miller", 40.7128, -74.0060, 0));
        users.add(new User(9, "James", "Anderson", 34.0522, -118.2437, 0));
        users.add(new User(10, "Olivia", "Wilson", 48.8566, 2.3522, 4));
        users.add(new User(11, "Liam", "Martinez", 40.7128, -74.0060, 4));
        users.add(new User(12, "Charlotte", "Jones", 51.5099, -0.1337, 4));
        users.add(new User(13, "Noah", "Garcia", 48.0521, 2.2435, 0));
        users.add(new User(14, "Ava", "Brown", 48.0522, 2.2437, 4));
        users.add(new User(148, "Avaa", "Browna", 48.0522, 2.2437, 0));
        users.add(new User(15, "Mia", "Smith", 40.7128, -74.0060, 0));
        users.add(new User(16, "Mia1", "Smith", 40.7128, -74.0060, 0));
        users.add(new User(41, "Emily1", "Brown", 48.8566, 2.3522, 0));
        users.add(new User(42, "Emily2", "Brown", 48.8566, 2.3522, 0));
        users.add(new User(43, "Emily3", "Brown", 48.8566, 2.3522, 0));
        users.add(new User(44, "Emily44", "Brown", 48.8566, 2.3522, 0));
        // Add more users

        List<Cluster> clusters = new ArrayList<>();

        for (User user : users) {
            boolean assigned = false;

            for (Cluster cluster : clusters) {
                if (cluster.canAddUser(user) && user.getDistanceTo(cluster.getCenter()) <= 2.0) {
                    cluster.addUser(user);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                Cluster cluster = new Cluster(user.getVehicleCapacity()); // Set the cluster capacity based on user's vehicle capacity
                cluster.addUser(user);
                clusters.add(cluster);
            }
        }

        // Print the final clusters
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + (i + 1) + ":");
            clusters.get(i).printUsers();
        }
    }

    static class User {
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
    }

    static class Cluster {
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
            latitudeSum += user.latitude;
            longitudeSum += user.longitude;
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
    }
}
