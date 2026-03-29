/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mini.e.commerce2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author prashnamshrestha
 */
public class InventoryManager {
    
    private List<Product> products = new ArrayList();
    public InventoryManager() {
        
        
    }
    
    public void addProduct(Product product) throws InvalidProductPrice{
        
        if (product.getPrice() < 0) {
            throw new InvalidProductPrice("Price cannot be negative.");
        }
        products.add(product);
    }
    
    public List<Product> getProductByCategory(CategoryProduct category) {
        
        if (products.size()  == 0){
            return null;
        }
        
        List<Product> filtered = products.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toList());
        
        return filtered;
    }
    
    public List<Product> getProductByExpensive(double price)  {
        if (products.size()  == 0){
            return null;
        }
        
        List<Product> filterd = products.stream()
                .filter(p -> p.getPrice() >= price)
                .collect(Collectors.toList());
        
        
        return filterd;
    }
}
