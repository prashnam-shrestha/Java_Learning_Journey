/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab.section1;

/**
 *
 * @author prashnamshrestha
 */
public class LabSection1 {

    public static void main(String[] args) {
        // Question 1
        Biography student1 = new Biography("Prashnam", 17, 1.65, true);
        student1.info();
        
        // Question 2
        Swap object1 = new Swap(10, 20);

        object1.Check();
        object1.SwapValues();
        object1.Check();
        
        // Question 3
        int ASCII = 'A';
        System.out.println(ASCII);
       
        
    }
    
    
}
