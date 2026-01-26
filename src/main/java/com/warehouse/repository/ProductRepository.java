package com.warehouse.repository;

import com.warehouse.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public void save(Product product) { products.add(product); }

    public List<Product> findAll() { return products; }

    public Optional<Product> findBySku(String sku) {
        return products.stream()
                .filter(p -> p.getSku().equals(sku))
                .findFirst(); // Поиск по артикулу [cite: 16]
    }

    public void delete(String sku) {
        products.removeIf(p -> p.getSku().equals(sku)); // Удаление [cite: 13]
    }
}