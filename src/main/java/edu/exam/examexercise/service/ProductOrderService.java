package edu.exam.examexercise.service;

import edu.exam.examexercise.entity.ProductOrder;
import edu.exam.examexercise.repository.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public List<ProductOrder> getAll() {
        return productOrderRepository.findAll();
    }
}
