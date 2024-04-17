package edu.exam.examexercise.controller;

import edu.exam.examexercise.entity.ProductOrder;
import edu.exam.examexercise.service.ProductOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/productorders")
public class ProductOrderController {
    private ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping
    public ResponseEntity<List<ProductOrder>> findAll() {
        var productOrders = this.productOrderService.getAll();
        if (productOrders != null) {
            return ResponseEntity.ok(productOrders);
        }
        return ResponseEntity.noContent().build();
    }
}
