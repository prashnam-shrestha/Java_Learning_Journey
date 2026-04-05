/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author prashnamshrestha
 */
public class InputHelper {
    
    public static int getValidInt(String text, int start, int end) {
        
        while (true) {
            
            try {
                System.out.print(text);
                
                int input = sc.nextInt();
                sc.nextLine();
                
                if (input < start || input > end) {
                    throw new InputOutOfBoundary(String.format("- Please enter between %s-%s\n", start, end));
                }
                return input;

            }
            catch (InputMismatchException e) {
                System.out.println("- Please enter a number!");
                sc.nextLine();

            }
            catch (InputOutOfBoundary e) {
                System.out.println(e.getMessage());
     
            }
        }
    }
    
    public static String getValidString(String text) {
        
        while (true) {
            try {
                System.out.print(text);
                
                String input = sc.nextLine();
                
                if (input.length() == 0) {
                    throw new InputIsEmpty("- Please enter a non-empty value.");
                }
                return input;
            }
            
            catch(InputIsEmpty e) {
                System.out.println(e.getMessage());
                
            }
        }
    }

    
    public static Scanner sc = new Scanner(System.in);
}
