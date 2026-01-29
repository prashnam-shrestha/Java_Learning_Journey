/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab.section1;

/**
 *
 * @author prashnamshrestha
 */
public class Swap {
    private int a;
    private int b;
    
    public Swap(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void SwapValues() {
        int temp = this.a;
        this.a = this.b;
        this.b = temp;
        System.out.println("Swapped " + a + " with " + b);
       
    }
    
    public void Check() {
        System.out.println("A: " + a + ", B: " + b);
    }
    
}
