package edu.exam.examexercise.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate deliveryDate;
    private String fromWareHouse;
    private String destination;
    @ManyToOne(fetch = FetchType.EAGER)
    private Van van;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ProductOrder> productOrders = new ArrayList<>();
    private Integer totalAmount;
}
