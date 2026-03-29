/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mini.e.commerce2;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author prashnamshrestha
 */
public class InventoryManagerTest {
    
   @Test
   public void checkNegativeProductPriceWorks() {
       Product p1 = new Product("Laptop", -1000, CategoryProduct.TECH);
       InventoryManager i = new InventoryManager();
       
       assertThrows(InvalidProductPrice.class, () -> {i.addProduct(p1);});
   }
   
   @Test
   public void checkFilterCategoryWorks() throws InvalidProductPrice{
       InventoryManager i = new InventoryManager();
       
        Product p1 = new Product("Laptop", 1000, CategoryProduct.TECH);
        Product p2 = new Product("Shirt", 200, CategoryProduct.CLOTH);
        Product p3 = new Product("Mobile", 600, CategoryProduct.TECH);
        Product p4 = new Product("Pants", 400, CategoryProduct.CLOTH);
        
        
        i.addProduct(p1);
        i.addProduct(p2);
        i.addProduct(p3);
        i.addProduct(p4); 
        
        
        assertEquals(2, i.getProductByCategory(CategoryProduct.TECH).size());
   }
    
}
