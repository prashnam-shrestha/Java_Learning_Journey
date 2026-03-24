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
                System.out.println("❌ [ERROR] Please enter a valid number!");
                sc.nextLine();
            } 
            catch (IllegalArgumentException e) {
                System.out.println("❌ [ERROR] Choice must be between " + start + " and " + end + ".");
            }
        }
    }
    
    public static String getValidString(String text) {
        while (true) {
            System.out.print(text);
            String input = sc.nextLine();
            if (input.length() <= 0){
                System.out.println("❌ [ERROR] Please enter a valid text!");
            }
            else {
                return input;
            }  
        }
    }
}