/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.store;

/**
 *
 * @author prashnamshrestha
 */
public final class Product {
    private String name;
    private double price;
    private int stock;
    
    public Product(String name, double price, int stock) {
        setName(name);
        setPrice(price);
        setStock(stock);
    }
    // --- For name ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            System.out.println("ALERT!! Unusual product name: " + name);
        }
        else {
            this.name = name;
        }
    }
    //--- For price ---
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("ALERT!! Unusual product price: " + price);
        }
        else 
        {
            this.price = price;  
        }
    }
    //--- For stock ---
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("ALERT!! Unusual product stock: " + stock);
        }
        else {
            this.stock = stock;
        }   
    }
}
