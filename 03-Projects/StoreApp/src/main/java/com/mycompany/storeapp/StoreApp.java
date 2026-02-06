/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.storeapp;

/**
 *
 * @author prashnamshrestha
 */
public class StoreApp {

    public static void main(String[] args) {
        
         // Test cases
        Product p1 = new Electronics("MacBook", 100000, "Apple", 2);
        Product p2 = new Electronics("Headphone", 10000, "Samsung", 3);
        Product p4 = new GiftCards("SummerLobby", 100, "Roblox");
        Product p3 = new Clothing("T-Shirt", 1000, 40, "Fabric");
        
        ShoppingCart cart1 = new ShoppingCart();
       
        cart1.addProduct(p3, 2);
        cart1.addProduct(p1);
        cart1.addProduct(p2);
        cart1.addProduct(p4);
        cart1.checkout();
        cart1.taxProduct();
        cart1.checkout();
        
        
    }
}
