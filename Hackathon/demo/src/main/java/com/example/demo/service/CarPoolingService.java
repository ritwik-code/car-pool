package com.example.demo.service;

import com.example.demo.model.Cluster;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarPoolingService {
    private List<Cluster> clusters = new ArrayList<>();


    public List<Cluster> formClusters(List<User> users) {
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
        return clusters;
    }

    public Optional<Cluster> getClustersByUserId(int userId) {
        return clusters.stream()
                .filter(cluster -> cluster.getUsers().stream().anyMatch(user -> user.getId() == userId))
                .findFirst();
    }
}
