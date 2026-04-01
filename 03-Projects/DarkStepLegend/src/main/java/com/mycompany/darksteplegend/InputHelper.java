package com.mycompany.darksteplegend;

import java.util.Scanner;

public class InputHelper {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static int getValidInt(String text, int start, int end) {
        while (true) {
            try {
                System.out.print(text);
                int input = sc.nextInt();
                sc.nextLine();

                if (input < start || input > end) {
                    throw new IllegalArgumentException();
                }

                return input;
            } 
            catch (java.util.InputMismatchException e) {
                System.out.println("\n  ❌ [INVALID INPUT] Only numeric values are allowed. Please try again.");
            } 
            catch (IllegalArgumentException e) {
                System.out.println("\n  ❌ [OUT OF BOUNDS] Your selection must be an exact number between " + start + " and " + end + ".");
            }
        }
    }
    
    public static String getValidString(String text) {
        while (true) {
            System.out.print(text);
            String input = sc.nextLine();
            if (input.length() <= 0){
                System.out.println("\n  ❌ [MISSING DATA] This field cannot be left blank. Please type something valid.");
            }
            else {
                return input;
            }  
        }
    }
}