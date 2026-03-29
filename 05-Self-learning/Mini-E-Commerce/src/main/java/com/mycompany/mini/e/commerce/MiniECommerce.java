/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mini.e.commerce;

/**
 *
 * @author prashnamshrestha
 */
public class MiniECommerce {

    public static void main(String[] args) throws InvalidPriceException {
        Product p = new Product("Laptop", "Tech", 1);
        InventoryManager i = new InventoryManager();
        i.addProduct(p);
        
        i.getProductsByCategory("Tech")
                .forEach(product -> System.out.print(product.getName()));
    }
}
