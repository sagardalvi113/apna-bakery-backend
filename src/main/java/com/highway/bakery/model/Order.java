package com.highway.bakery.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Entity @Table(name="orders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerPhone;
    @Enumerated(EnumType.STRING)
    private com.highway.bakery.model.OrderStatus status = com.highway.bakery.model.OrderStatus.PENDING;
    private Instant createdAt = Instant.now();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<com.highway.bakery.model.OrderItem> items = new ArrayList<>();
    @Column(precision = 10, scale = 2)
    private BigDecimal totalAmount;
}
