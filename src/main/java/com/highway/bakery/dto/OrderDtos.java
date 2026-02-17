package com.highway.bakery.dto;

import java.util.List;

public class OrderDtos {
    public record OrderItemIn(Long productId, int quantity) {}
    public record PlaceOrderRequest(String customerName, String customerPhone, List<OrderItemIn> items) {}
}
