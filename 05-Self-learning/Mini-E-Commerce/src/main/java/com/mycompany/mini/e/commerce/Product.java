/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mini.e.commerce;

/**
 *
 * @author prashnamshrestha
 */
public class Product {
    
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Generate your Getters here!
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
}
