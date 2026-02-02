/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.flowcontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class FlowControl {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        
        // Qn 1
        int num = scanner.nextInt();
        if (num < 0) {
            System.out.println("Negative");
        }
        else {
            System.out.println("Positive");
        }
        
        // Qn 2
        if ((num % 2) == 0) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
        
        // Qn 3
        if (num > 10) {
            System.out.println("Greater then 10");
        }
        else {
            System.out.println("Not greater then 10");         
        }
        
        // Qn 4
        if (num >= 18) {
            System.out.println("Can vote");
        }
        else {
            System.out.println("Cannot vote");
        }
        
        // Qn 5
        if (num == 0) {
            System.out.println("It is zero");
        }
        else {
            System.out.println("Not zero");
        }
        
        // Qn 6
        System.out.print("Enter num 1: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter num 2: ");
        int num2 = scanner.nextInt();
        
        if (num1 > num2) {
            System.out.print(num1 + " is greater");
        }
        else if (num2 > num1) {
            System.out.print(num2 + " is greater");
        }
        
        // Qn 7
        System.out.print("Enter marks: ");
        int marks = scanner.nextInt();
        if (marks >= 40) {
            System.out.println("Passed");
        }
        else {
            System.out.println("Failed");
        }
        
        // Qn 8
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        if (((year % 400) == 0) || ((year % 4 ) == 0)) {
            System.out.println("It is leap year");
        }
        else {
            System.out.println("It is not leap year");
        }
        
        // Qn 9
        System.out.print("Enter letter:");
        char letter = scanner.next().charAt(0);
        
        letter = Character.toLowerCase(letter);
        
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        for (int i = 0; i < 5; i++) {
            if (vowels.get(i) == letter) {
                System.out.println("It is vowel");
                break;
            }
        }
        

        
    }
}
