/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab.section4;

/**
 *
 * @author prashnamshrestha
 */
public class LabSection4 {

    public static void main(String[] args) {
        // Question 1
        int n = 15;
        boolean betweenTenAndTwenty = false;
        
        if (n > 10 && n < 20) {
            betweenTenAndTwenty =  true;
        }
        System.out.println(betweenTenAndTwenty);
        
        // Question 2
        boolean isSaturday = true;
        boolean isSunday = false;
        boolean canSleep = false;
        if (isSaturday || isSunday) {
            canSleep = true;
        }
        System.out.println(canSleep);
        
        // Question 3
        int a = 5;
        int b = 10;
        int c = 15;
        boolean logic = false;
        if ( (a < b) && (b < c) || (a == 5) ) {
            logic = true;
        }
        System.out.println(logic);
        
    }
}
