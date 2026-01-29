/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.store;

/**
 *
 * @author prashnamshrestha
 */
public class Store {

    public static void main(String[] args) {
        Product Laptop = new Product("Laptop",1200.0,10);
        System.out.println("Product: " + Laptop.getName() + " is $" +
                 Laptop.getPrice() + "(" + Laptop.getStock()+ " left).");
        
        Laptop.setPrice(-500);
        Laptop.setStock(-20);
        
        System.out.println("Product: " + Laptop.getName() + " is $" +
                 Laptop.getPrice() + "(" + Laptop.getStock()+ " left).");
        
        
    }
}
