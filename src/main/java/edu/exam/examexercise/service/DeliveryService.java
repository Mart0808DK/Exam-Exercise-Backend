package edu.exam.examexercise.service;

import edu.exam.examexercise.entity.Delivery;
import edu.exam.examexercise.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getById(Long id) {
        return Optional.ofNullable(deliveryRepository.findById(id).orElse(null));
    }

    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}
