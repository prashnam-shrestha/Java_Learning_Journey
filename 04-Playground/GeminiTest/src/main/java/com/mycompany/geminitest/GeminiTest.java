/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.geminitest;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class GeminiTest {

    public static void main(String[] args) {
        int totalRuns = 501;
        int totalInnings = 10;
        final int MAX_overs = 50;
        
        double average = (double) totalRuns/ totalInnings;
        System.out.println(average);
        
        // Problem 2
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Say hello");
            System.out.println("2. Tell me the time");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1: 
                    System.out.println("HELLO");
                    break;
                case 2:
                    System.out.println(LocalDateTime.now());
                    break;
                case 3:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 3);
        
        // Problem 3
        int height = sc.nextInt();
        
        for (int i = 1; i <= height; i++) {
            
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Bonus;
        
        for (int i = 0; i < height; i++) {
            
            for (int j = 0; j < (height - i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = 1; i <= height; i++) {
            
            for (int j = 0; j < (height - i); j++ ) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
            
            
        }
        // Problem: bonus challenge
        double balance = 1000.50;
        final double FEE_withdraw = 3.50;
        
        double withdrawAmt = sc.nextDouble();
        if (withdrawAmt < 0) {
            System.out.println("Cant withdraw negative money");
                   
        }
        else if (withdrawAmt > (balance - FEE_withdraw)) {
            System.out.println("Insufficient balance");
        }
        else {
            balance -= withdrawAmt;
            balance -= FEE_withdraw;
            System.out.printf("Withdrawn Rs %s.2f with fee.\n", withdrawAmt);
        } 
        System.out.println("balance" + balance);
       
        
    }
    
}
