/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.flowcontrolterative;

import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class FlowControlterative {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        
//        // Qn 1
//        System.out.println("1. Write a program to print numbers from 1 to 10 using a for loop.");
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + 1);
//        }
//        
//        // Qn 2
//        System.out.println("2. Write a program to print even numbers between 1 and 50.");
//        for (int i = 1; i <= 50; i++) {
//            if (i % 2 == 0) {
//                System.out.println(i);
//            }
//        }
//        
//        // Qn 3
//        System.out.println("3. Write a program to calculate the sum of first N natural numbers.");
//        int sum = 0;
//        for (int i = 0; i < 10; i++) {
//            sum++;
//        }
//        System.out.println("SUM:" + sum);
//        
//        // Qn 4 
//        System.out.println("4. Write a program to print the multiplication table of a given number.");
//        System.out.print("Enter number: ");
//        int num = sc.nextInt();
//        sc.nextLine();
//        
//        for (int i = 0; i < 11; i++) {
//            System.out.printf("%s x %s = %s\n", num, i, num*i);
//        }
//        
//        // Qn 5
//        System.out.println("5. Write a program to print the square of numbers from 1 to 10.");
//        for (int i = 1; i <= 10; i++) {
//            System.out.printf("Square of %s = %s\n", i, i*i);
//        }
//        
//        // Qn 6 
//        System.out.println("6. Write a program to count how many numbers between 1 and 100 are divisible by 5.");
//        for (int i = 0; i <= 100; i++) {
//            if (i % 5 == 0) {
//                System.out.println(i);
//            }
//        }
//        
//        // Qn 7
//        System.out.print("Enter a number: ");
//        int num1 = sc.nextInt();
//        sc.nextLine();
//        
//        for(int i = num1; i != 0; i--) {
//            System.out.println(i);
//        }
//        
//        // Qn 8
//        // 1x2x3x4x5  
        System.out.print("Enter a number: ");
        int num2 = sc.nextInt();
        int result = num2;
        if (result == 0) {
            result ++;
        }

        for (int i = 1; i < num2; i++) {
            
            result = result * i;
            
        }
        System.out.println(result);
        
        
       
    } 
}
