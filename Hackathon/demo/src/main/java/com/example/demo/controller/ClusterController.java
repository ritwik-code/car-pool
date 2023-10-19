package com.example.demo.controller;

import com.example.demo.model.Cluster;
import com.example.demo.model.User;
import com.example.demo.service.CarPoolingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClusterController {

    @Autowired
    private final CarPoolingService clusterService;

    public ClusterController(CarPoolingService clusterService) {
        this.clusterService = clusterService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveNewUser(
            @RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam int vehicleCapacity
    ) {

        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLatitude(latitude);
        user.setLongitude(longitude);
        user.setVehicleCapacity(vehicleCapacity);

        boolean result = clusterService.addUser(user);

        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/health-check")
    public String getHealth() {
        return "App is healthy is the, we are wealthy is the";
    }

    @GetMapping("/clusters")
    public ResponseEntity<Cluster> getClustersByUserId(@RequestParam int userId) {
        Optional<Cluster> cluster = clusterService.getClustersByUserId(userId);
        if (cluster.isPresent()) {
            return ResponseEntity.ok(cluster.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
