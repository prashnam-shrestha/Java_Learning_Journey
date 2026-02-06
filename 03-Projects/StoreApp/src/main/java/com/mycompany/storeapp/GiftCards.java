/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storeapp;

/**
 *
 * @author prashnamshrestha
 */
public class GiftCards extends Product {
    
    private String game;
    
    public GiftCards(String name, double price, String game) {
        super(name, price);
        setGame(game);
        
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
    
    // Methods overriding
    public double calculateDiscount() {
        
        // Calculate discount
        double price = this.getPrice();
        double discount = (0.1 * price);
        return discount;
    }
}
