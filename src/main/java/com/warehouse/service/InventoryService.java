package com.warehouse.service;

import com.warehouse.model.Product;
import com.warehouse.repository.ProductRepository;
import com.warehouse.exception.InsufficientStockException;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryService {
    private final ProductRepository repository = new ProductRepository();

    public void addProduct(Product product) {
        if (product.getPrice() < 0 || product.getQuantity() < 0) {
            throw new IllegalArgumentException("Цена и количество не могут быть отрицательными");
        }
        repository.save(product);
    }

    public void updateQuantity(String sku, int amount) {
        Product product = repository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Товар не найден"));

        int newQuantity = product.getQuantity() + amount;
        if (newQuantity < 0) {
            throw new InsufficientStockException("Недостаточно товара на складе");
        }
        product.setQuantity(newQuantity);
    }

    public double calculateTotalValue() {
        return repository.findAll().stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    public List<Product> getLowStockProducts(int threshold) {
        return repository.findAll().stream()
                .filter(p -> p.getQuantity() < threshold)
                .collect(Collectors.toList());
    }
}