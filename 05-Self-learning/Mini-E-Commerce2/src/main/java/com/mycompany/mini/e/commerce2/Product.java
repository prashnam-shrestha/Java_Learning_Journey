/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mini.e.commerce2;

/**
 *
 * @author prashnamshrestha
 */
public class Product {
    
    private String name;
    private double price;
    private CategoryProduct category;
    
    public Product(String name, double price, CategoryProduct category) {
        setName(name);
        setPrice(price);
        setCategory(category);
    }

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

    public CategoryProduct getCategory() {
        return category;
    }

    public void setCategory(CategoryProduct category) {
        this.category = category;
    }
    
    
}
