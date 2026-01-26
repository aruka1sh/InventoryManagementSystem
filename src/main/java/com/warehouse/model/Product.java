package com.warehouse.model;

public class Product {
    private String sku; // Артикул
    private String name;
    private String category;
    private int quantity;
    private double price;

    public Product(String sku, String name, String category, int quantity, double price) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Геттеры и сеттеры (обязательно для Service и Repository)
    public String getSku() { return sku; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    // ... остальные геттеры
}