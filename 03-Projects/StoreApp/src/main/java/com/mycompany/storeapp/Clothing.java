/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storeapp;

/**
 *
 * @author prashnamshrestha
 */
public class Clothing extends Product {
    private double size;
    private String Material;
    
    public Clothing(String name, double price, double size, String material) {
        super(name, price);
        setSize(size);
        setMaterial(material);
        
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }
    
    // Methods overriding
    public double calculateDiscount() {
        
        // Calculate discount
        double price = this.getPrice();
        double discount = (0.4 * price);
        return discount;
    }
    
    
    
    
}
