package com.highway.bakery.config;

import com.highway.bakery.model.Product;
import com.highway.bakery.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ProductDataSeeder {

    @Bean
    CommandLineRunner seedProducts(ProductRepository products) {
        return args -> {
            if (products.count() == 0) {
                products.saveAll(List.of(
                        Product.builder().name("Buttery Khari").description("Crispy, flaky puff pastry with buttery layers").price(new BigDecimal("35.00")).category("Khari").imageUrl("").available(true).build(),
                        Product.builder().name("Classic Bread").description("Soft white loaf, freshly baked").price(new BigDecimal("60.00")).category("Bread").imageUrl("").available(true).build(),
                        Product.builder().name("Almond Biscuit").description("Crunchy biscuits with almond pieces").price(new BigDecimal("25.00")).category("Biscuits").imageUrl("").available(true).build(),
                        Product.builder().name("Rusk Slice").description("Double-baked rusk, perfect with tea").price(new BigDecimal("20.00")).category("Rusk").imageUrl("").available(true).build(),
                        Product.builder().name("Chocolate Cake").description("Moist chocolate sponge with ganache").price(new BigDecimal("450.00")).category("Cakes").imageUrl("").available(true).build(),
                        Product.builder().name("Spicy Namkeen").description("Savory namkeen mix for snacking").price(new BigDecimal("45.00")).category("Namkeen").imageUrl("").available(true).build()
                ));
            }
        };
    }
}
