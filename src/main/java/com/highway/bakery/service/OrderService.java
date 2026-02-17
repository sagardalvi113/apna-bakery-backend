package com.highway.bakery.service;

import com.highway.bakery.dto.OrderDtos;

import com.highway.bakery.model.Order;
import com.highway.bakery.model.OrderItem;
import com.highway.bakery.model.OrderStatus;
import com.highway.bakery.repo.OrderRepository;
import com.highway.bakery.repo.ProductRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class OrderService {
    private final OrderRepository orders;
    private final ProductRepository products;


    public OrderService(OrderRepository orders, ProductRepository products) {
        this.orders = orders; this.products = products;
    }

    public Order place(OrderDtos.PlaceOrderRequest req) {
        var items = new ArrayList<OrderItem>();
        BigDecimal total = BigDecimal.ZERO;
        for (var i : req.items()) {
            var p = products.findById(i.productId()).orElseThrow();
            var it = OrderItem.builder().product(p).quantity(i.quantity())
                    .price(p.getPrice()).build();
            items.add(it);
            total = total.add(p.getPrice().multiply(BigDecimal.valueOf(i.quantity())));
        }
        var order = Order.builder().customerName(req.customerName()).customerPhone(req.customerPhone())
                .items(items).totalAmount(total).status(OrderStatus.PENDING).build();
        return orders.save(order);
    }

    public Order updateStatus(Long id, OrderStatus status) {
        var o = orders.findById(id).orElseThrow();
        o.setStatus(status);
        return orders.save(o);
    }
}
