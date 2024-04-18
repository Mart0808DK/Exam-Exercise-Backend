package edu.exam.examexercise.service;

import edu.exam.examexercise.entity.Delivery;
import edu.exam.examexercise.entity.ProductOrder;
import edu.exam.examexercise.entity.Van;
import edu.exam.examexercise.errorhandling.OverweightException;
import edu.exam.examexercise.repository.DeliveryRepository;
import edu.exam.examexercise.repository.ProductOrderRepository;
import edu.exam.examexercise.repository.VanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final ProductOrderRepository productOderRepository;
    private final VanRepository vanRepository;

    public DeliveryService(DeliveryRepository deliveryRepository, ProductOrderRepository productOderRepository, VanRepository vanRepository) {
        this.deliveryRepository = deliveryRepository;
        this.productOderRepository = productOderRepository;
        this.vanRepository = vanRepository;
    }

    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getById(Long id) {
        return Optional.ofNullable(deliveryRepository.findById(id).orElse(null));
    }

    public Delivery save(Delivery delivery) {

        Van van = vanRepository.findById(delivery.getVan().getId())
                .orElseThrow(() -> new RuntimeException("Van not found"));


        List<Long> productOrderIds = delivery.getProductOrders().stream()
                .map(ProductOrder::getId)
                .collect(Collectors.toList());
        List<ProductOrder> productOrders = productOderRepository.findAllById(productOrderIds);
        if (productOrders.size() != productOrderIds.size()) {
            throw new RuntimeException("Some ProductOrders not found");
        }


        delivery.setVan(van);
        delivery.setProductOrders(productOrders);

        calculateTotalAmount(delivery);
        calculateWeightInVan(delivery);


        return deliveryRepository.save(delivery);
    }

    public List<Delivery> findByVanId(Long vanId) {
        return deliveryRepository.findByVanId(vanId);
    }

    public void calculateWeightInVan(Delivery delivery) {
        double totalWeight = 0;
        for (ProductOrder productOrder : delivery.getProductOrders()) {
            totalWeight += productOrder.getProduct().getWeightInGrams() * productOrder.getQuantity();
        }

        totalWeight /= 1000;


        if (totalWeight > delivery.getVan().getCapacityInKg()) {
            throw new OverweightException("Total weight of products exceeds van's capacity");
        }

    }

    public void calculateTotalAmount(Delivery delivery) {
        int totalAmount = 0;
        for (ProductOrder productOrder : delivery.getProductOrders()) {
            totalAmount += (int) (productOrder.getProduct().getPrice() * productOrder.getQuantity());
        }
        delivery.setTotalAmount(totalAmount);
    }
}
