package edu.exam.examexercise.repository;

import edu.exam.examexercise.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOderRepository extends JpaRepository<ProductOrder, Long> {
}
