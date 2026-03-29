/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mini.e.commerce2;

import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class MiniECommerce2 {

    public static void main(String[] args){
        
        Product p1 = new Product("Laptop", 1000, CategoryProduct.TECH);
        Product p2 = new Product("Shirt", 200, CategoryProduct.CLOTH);
        Product p3 = new Product("Mobile", 600, CategoryProduct.TECH);
        Product p4 = new Product("Pants", 400, CategoryProduct.CLOTH);
        
        InventoryManager i = new InventoryManager();
        
        try {
            i.addProduct(p1);
            i.addProduct(p2);
            i.addProduct(p3);
            i.addProduct(p4);  
        }
        catch (InvalidProductPrice error) {
            System.out.println("Error: Price cannot be declared negative.");
        }
        
        List<Product> productsCategoryWise =  i.getProductByCategory(CategoryProduct.TECH);
        if (productsCategoryWise == null) {
            return;
        }
        
        i.getProductByCategory(CategoryProduct.TECH)
                .forEach(p -> System.out.println(p.getName()));
    }
}
