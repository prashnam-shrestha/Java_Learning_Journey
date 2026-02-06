/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storeapp;

/**
 *
 * @author prashnamshrestha
 */
public class Electronics extends Product implements Taxable {
    
    private String brand;
    private int warrantyPeriod;
    
    public Electronics(String name, double price, String brand, 
            int warrantyPeriod) {
        
        super(name, price);
        setBrand(brand);
        setWarrantyPeriod(warrantyPeriod);

    }
    
    public double calculateDiscount() {
        // Calculate discount
         double price = this.getPrice();
         double discount = (0.1 * price);
         return discount;
         
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    
    public double getTax() {
        
        double price = this.getPrice();
        double taxAmount = price * 0.4;
        this.setPrice(price + taxAmount);
        return taxAmount;
    }
    
}
