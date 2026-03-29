/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mini.e.commerce;

/**
 *
 * @author prashnamshrestha
 */
import java.util.ArrayList;
import java.util.List;import java.util.stream.Collectors;
;

public class InventoryManager {
    
    private List<Product> products = new ArrayList<>();
    
    public InventoryManager() {
        
    }

    // 1. Throw your custom exception if the price is < 0. Otherwise, add to list.
    public void addProduct(Product p) throws InvalidPriceException {
        
        if (p.getPrice() < 0) {
            throw new InvalidPriceException("Price cannot be negative.");
        }
        products.add(p);
    }

    // 2. Use a Stream to return ONLY products that match the given category
    public List<Product> getProductsByCategory(String category) {
        
        if (this.products.size() == 0 ) {
            return null;
        }
  
        List<Product> newList = products.stream()
            .filter(p -> p.getCategory().equals(category))
            .collect(Collectors.toList());
        
        return newList; 
    }

    // 3. Use a Stream to find all products that cost more than the given price
    public List<Product> getExpensiveProducts(double minimumPrice) {
        // TODO: Use streams to filter the list
        if (this.products.size() == 0) {
            return null;
        }
        
        List<Product> newList2= products.stream()
                .filter(p -> p.getPrice() >= minimumPrice)
                .collect(Collectors.toList());
        return newList2;
    }
}
