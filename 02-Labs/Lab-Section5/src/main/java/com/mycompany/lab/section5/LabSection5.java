/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab.section5;

/**
 *
 * @author prashnamshrestha
 */
public class LabSection5 {

    public static void main(String[] args) {
        // Question 1;
        int P = 1000;
        int T = 4;
        double R = 2.5;
        
        double simpleInterest = (P * T * R) / 100;
        double totalAmount = P + simpleInterest;
        
        System.out.println(simpleInterest);
        System.out.println(totalAmount);
        
        // Question 2
        int a = 97;
        int b = 97;
        boolean result = false;
        if (a % 10 == b % 10) {
            result = true;
        }
        
        System.out.println(result);
        
        
    }
}
