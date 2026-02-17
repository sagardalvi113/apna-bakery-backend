package com.highway.bakery.controller;

import com.highway.bakery.dto.OrderDtos.*;
import com.highway.bakery.model.Order;
import com.highway.bakery.model.OrderStatus;
import com.highway.bakery.repo.OrderRepository;
import com.highway.bakery.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    private final OrderRepository repo;
    public OrderController(OrderService service, OrderRepository repo) { this.service = service; this.repo = repo; }

    @PostMapping
    public ResponseEntity<Order> place(@RequestBody PlaceOrderRequest req) {
        return ResponseEntity.ok(service.place(req));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> status(@PathVariable("id") Long id, @RequestParam("status") OrderStatus status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable("id") Long id) { return ResponseEntity.of(repo.findById(id)); }

    @GetMapping("/search")
    public List<Order> search(@RequestParam("q") String q) { return repo.search(q); }

    @GetMapping
    public List<Order> all() { return repo.findAll(); }

   /* @GetMapping("/debug")
    public List<Order> debugOrders() {
        List<Order> orders = repo.findAll();
        orders.forEach(order -> System.out.println("Order ID: " + order.getId() + ", Created At: " + order.getCreatedAt()));
        return orders;
    }*/
}
