/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storeapp;

/**
 *
 * @author prashnamshrestha
 */
public abstract class Product {
    private String name;
    private double price;
    private int productId;
    
    static int totalProduct = 0;
    
    public Product(String name, double price) {
        totalProduct++;
        setName(name);
        setPrice(price);
        setProductId(totalProduct);
        
    }
    
    public abstract double calculateDiscount();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        
        this.productId = productId + 10000;
    }

    public static int getTotalProduct() {
        return totalProduct;
    }

    public static void setTotalProduct(int totalProduct) {
        Product.totalProduct = totalProduct;
    }
    
    
}
