/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hashmaplearning;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class HashMapLearning {

    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);
        
        HashMap menu = new HashMap();
        menu.put("Burger", 200);
        menu.put("Biryani", 120);
        
        System.out.print("Food name: ");
        String food = sc.nextLine();
        
        if (menu.containsKey(food)) {
            System.out.printf("That will be $%s please!\n", menu.get(food));
            return;
        }
        System.out.printf("Sorry we dont serve %s\n", food);
        
    } 
    
}
