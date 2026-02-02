/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storeapp;

import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class ShoppingCart {
    ArrayList<Product> cart = new ArrayList<Product>();
    
    public ShoppingCart() {
        
    }
    
    public void addProduct(Product product) {
        cart.add(product);
        System.out.printf("%s added on cart.\n",product.getName());
    }
    
    public void addProduct(Product product, int quantity) {
        
        for (int i = 0; i < quantity; i++) {
            cart.add(product);
        }
        System.out.printf("%s x %s added on cart.\n", quantity, product.getName());
    
    }
    
    public void checkout() {
        
        double totalSum = 0;
        System.out.println("---- Your cart ----\n");
        
        for (Product product: cart) {
            
            double calculatedPrice = product.getPrice() - product.calculateDiscount();
            totalSum += calculatedPrice; 
            System.out.printf("Product: %s | ID: %s | Final price : Rs %s \n", product.getName(), product.getProductId(), calculatedPrice);
        }
        System.out.printf("Total price: Rs %s\n", totalSum);
    }
}
