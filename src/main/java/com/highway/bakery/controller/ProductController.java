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

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return products.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product updated) {
        return products.findById(id).map(p -> {
            p.setName(updated.getName());
            p.setDescription(updated.getDescription());
            p.setImageUrl(updated.getImageUrl());
            p.setPrice(updated.getPrice());
            p.setCategory(updated.getCategory());
            p.setAvailable(updated.isAvailable());
            return products.save(p);
        }).orElseGet(() -> {
            updated.setId(id);
            return products.save(updated);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        products.deleteById(id);
    }
}
