package com.highway.bakery.controller;

import com.highway.bakery.model.Product;
import com.highway.bakery.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository products;
    public ProductController(ProductRepository products) { this.products = products; }

    @GetMapping
    public List<Product> allProducts() {
        return products.findAll();
    }

    @GetMapping("/shop/{shopId}")
    public List<Product> productsByShop(@PathVariable("shopId") Long shopId) {
        // Single-shop app: return all products regardless of shopId to satisfy frontend
        return products.findAll();
    }
}
