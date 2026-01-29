/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utility;

/**
 *
 * @author prashnamshrestha
 */
public class MathHelper {
    public void findMax(int x, int y)
    {
        if (x == y) {
            System.out.println("Equal"); 
        }
        else if (x > y) {
            System.out.println("Greater is " + x); 
        }
        else {
            System.out.println("Greater is " + y);  
        }
        
    }
    
    public void findMax(int x, int y, int z) {
        if (x == y && z == y) {
            System.out.println("Equal");
        }
        else if (x > y && x > z) {
            System.out.println("Greater is " + x); 
        }
        else if (y > z && y > x) {
            System.out.println("Greater is " + y);
        }
        else {
            System.out.println("Greater is " + z);
        }
    }
    
    public void findMax(double x, double y) {
        if (x == y) {
            System.out.println("Equal"); 
        }
        else if (x > y) {
            System.out.println("Greater is " + x); 
        }
        else {
            System.out.println("Greater is " + y);  
        }
    }
}
