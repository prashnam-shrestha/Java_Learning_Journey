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
        if (((year % 400) == 0) || ((year % 4 ) == 0) && ((year % 100 ) != 0 ) ){
            System.out.println("It is leap year");
        }
        else {
            System.out.println("It is not leap year");
        }
        
        // Qn 9 DONE IN A COMPLEX WAY TO BOOST CONCEPT INSDEAD OF SIMPLER WAY
        System.out.print("Enter letter:");
        char letter = scanner.next().charAt(0);
        
        letter = Character.toLowerCase(letter);
        boolean leapyear = false;
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        for (int i = 0; i < 5; i++) {
            if (vowels.get(i) == letter) {
                leapyear = true;
                System.out.println("It is vowel");
                break;
            }
        }
        if (!leapyear) {
            System.out.println("It is not a vowel");
        }
        
        // Qn 10 
        System.out.print("Enter number");
        int numCheck = scanner.nextInt();
        if (numCheck >= 1 && numCheck <= 100) {
            System.out.println("It is in between 1 and 100");
        }
        else {
            System.out.println("It is not in between 1 and 100");
        }
        
        // Qn 11
        System.out.print("Enter number: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter number: ");
        int number2 = scanner.nextInt();
        System.out.print("Enter number: ");
        int number3 = scanner.nextInt();
        
        System.out.printf("Largest: %s\n", Math.max(number1, Math.max(number2, number3)));
         
        // Qn 12
        System.out.print("Enter grade: ");
        int grade = scanner.nextInt();
        if (grade >= 90) {
            System.out.println("A");
        }
        else if (grade >= 75) {
            System.out.println("B");
        }
        else if (grade >= 60) {
            System.out.println("C");
        }
        else {
            System.out.print("Fail");
        }
        
        // Qn 13
        System.out.print("Enter number: ");
        int numberDivisible = scanner.nextInt();
        if ((numberDivisible % 5 == 0 ) && (numberDivisible % 11 == 0)) {
            System.out.println("It is divisible by 5 and 11");
        }
        else {
            System.out.println("It is not divisible by 5 and 11");
        }
        
        // Qn 14
        System.out.print("Enter String: ");
        scanner.nextLine();
        String userString = scanner.nextLine();
        if (userString.equals(userString.toUpperCase())) {
            System.out.println("It is all uppercase");
        }
        else {
            System.out.println("It is not all uppercase");
        }
        
        // Qn 15
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        if (number % 3 == 0) {
            System.out.println("It is multiple of 3");
        }
        else if(number % 7 == 0) {
            System.out.println("It is multiple of 7");
        } 
    }
}
