/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restrurant;

/**
 *
 * @author prashnamshrestha
 */
public class Burger {
    private String name;
    private double price;
    
    // Constructors
    public Burger(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public void addTopping(String toppingName) {
        this.price += 1.0;
        System.out.println("Added " + toppingName + " for $" + 1.00);
    }
    
    public void addTopping(String toppingName, double cost) {
        this.price += cost;
        System.out.println("Added " + toppingName + " for $" + cost);
        
    }
    
    public void receipt() {
        System.out.println("Total cost of : " + name + " is: $" + price);
    }

    
}
