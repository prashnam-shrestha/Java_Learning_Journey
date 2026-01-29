/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

/**
 *
 * @author prashnamshrestha
 */

public class Calculate {
    public void add(int x, int y){
        System.out.println( x + " + " + y + " : " + (x+y));
    }
    
    // In Java default arguements dont exit.
    // We have to declare a new method with different arguement.
    public void add(int x, int y, int z)
    {
        System.out.println(x + " + " + y + " + " +  z + " : " + (x+y+z));
    }
    
    public void add(double x, double y){
        System.out.println(x + " + " + y + " : " + (x+y));
    }
            
    
}
