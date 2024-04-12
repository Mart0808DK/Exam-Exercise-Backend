package edu.exam.examexercise.controller;

import edu.exam.examexercise.entity.Delivery;
import edu.exam.examexercise.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Delivery> create(@RequestBody Delivery delivery) {
        if(delivery == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.deliveryService.save(delivery));
    }
}
