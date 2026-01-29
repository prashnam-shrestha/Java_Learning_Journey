/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restrurant;

/**
 *
 * @author prashnamshrestha
 */
public class Restrurant {

    public static void main(String[] args) {
        // Declaring or Creating an object using a class blueprint
        Burger order1 = new Burger("Cheese Beef", 5);
        
        order1.addTopping("Cheese");
        order1.addTopping("Extra Cheese", 3);
        order1.receipt();
        
        Burger order2 =  new Burger("Jaw dropper", 10);
        
        order2.addTopping("Pepperoni");
        order2.addTopping("Extra cheese", 4);
        order2.receipt();
           
        
        
     
    }
}
