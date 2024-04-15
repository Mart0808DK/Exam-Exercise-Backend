package edu.exam.examexercise.repository;

import edu.exam.examexercise.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByVanId(Long vanId);
}
