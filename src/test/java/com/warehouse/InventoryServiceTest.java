package com.warehouse;

import com.warehouse.model.Product;
import com.warehouse.service.InventoryService;
import com.warehouse.exception.InsufficientStockException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {
    private InventoryService service;

    @BeforeEach
    void setUp() {
        service = new InventoryService();
        service.addProduct(new Product("A1", "Товар", "Категория", 10, 100.0));
    }

    @Test
    void testUpdateQuantitySuccess() {
        service.updateQuantity("A1", -5);
        // Проверка прошла успешно, если не вылетело исключение
    }

    @Test
    void testCalculateTotalValue() {
        assertEquals(1000.0, service.calculateTotalValue());
    }

    @Test
    void testInsufficientStockThrowsException() {
        assertThrows(InsufficientStockException.class, () -> service.updateQuantity("A1", -15));
    }
}