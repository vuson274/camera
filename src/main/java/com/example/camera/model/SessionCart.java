package com.example.camera.model;


public class SessionCart {
    private Product products;
    private int quantity;

    public SessionCart(Product products, int quantity) {
        this.products = products;
        this.quantity = quantity;
    }

    public SessionCart() {

    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
