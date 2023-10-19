package com.example.demo.controller;

import com.example.demo.model.Cluster;
import com.example.demo.service.CarPoolingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClusterController {

    private final CarPoolingService clusterService;

    @Autowired
    public ClusterController(CarPoolingService clusterService) {
        this.clusterService = clusterService;
    }

    @PostMapping("/saveUser")
    public void saveNewUser(@RequestBody String newUser) {
        System.out.println(newUser);
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
