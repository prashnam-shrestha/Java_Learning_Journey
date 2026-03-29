/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mini.e.commerce;

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
    public void testExceptionIsThrownForNegativePrice() {
        InventoryManager manager = new InventoryManager();
        Product badProduct = new Product("Glitchy Laptop", "Electronics", -500.0);

        // TODO: Use assertThrows() to check that adding badProduct throws InvalidPriceException
        assertThrows(InvalidPriceException.class, () -> 
            {manager.addProduct(badProduct);});
    }

    @Test
    public void testStreamFiltersCategoryCorrectly() throws InvalidPriceException {
        InventoryManager manager = new InventoryManager();
        
        // Setup dummy data
        manager.addProduct(new Product("Laptop", "Electronics", 1200));
        manager.addProduct(new Product("Mouse", "Electronics", 25));
        manager.addProduct(new Product("Desk", "Furniture", 150));

        // TODO: Call your stream method to get only "Electronics"
        // List<Product> electronics = ...
        List<Product> electronics = manager.getProductsByCategory("Electronics");
        
        // TODO: Use assertEquals() to prove that the size of the returned list is exactly 2!
        assertEquals(2, electronics.size());
    }
    
}
