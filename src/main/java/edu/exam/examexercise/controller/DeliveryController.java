package edu.exam.examexercise.controller;

import edu.exam.examexercise.entity.Delivery;
import edu.exam.examexercise.errorhandling.OverweightException;
import edu.exam.examexercise.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getAll() {
        return ResponseEntity.ok(this.deliveryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.deliveryService.getById(id).orElse(null));
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Delivery delivery) {
        try {
            return ResponseEntity.ok(this.deliveryService.save(delivery));
        } catch (OverweightException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/van/{vanId}")
    public ResponseEntity<List<Delivery>> findByVanId(@PathVariable Long vanId) {
        return ResponseEntity.ok(this.deliveryService.findByVanId(vanId));
    }
}
