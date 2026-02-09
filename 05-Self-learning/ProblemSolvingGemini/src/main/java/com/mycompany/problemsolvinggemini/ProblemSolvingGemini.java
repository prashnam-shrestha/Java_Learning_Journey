/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problemsolvinggemini;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class ProblemSolvingGemini {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // The warm up
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        int lastIndex = text.length() - 1;
        for(int i = lastIndex; i != -1; i--) {
            System.out.print(text.charAt(i));
        }
        System.out.println();
        
        // Qn2
        System.out.print("Enter text: ");
        String userText = sc.nextLine();
        
        String palindromText = userText.toLowerCase();
        ArrayList<Character> backwards = new ArrayList<>();
        boolean palindrom = true;
        int lastIndex2 = palindromText.length() - 1;
        
        // Filter adding letters backward in arrayList
        for(int i = lastIndex2; i != -1; i--) {
            
            char letter = palindromText.charAt(i);
            if (letter >= 97 && letter <= 122) {
                backwards.add(letter);
            }
        }
        // Filter checking if array and string is same
        for(int i = 0; i < lastIndex2 - 1; i++) {
            
            char letter = palindromText.charAt(i);
            
            if(letter >= 97 && letter <= 122) {
                if (letter != backwards.get(i)) {
                    palindrom = false;
                    break;
                }
            }
        }
        System.out.println(palindrom);
        
        // Qn3
        for (int i = 0; i <= 100; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("FizzBuzz");
            }
            else if ((i % 3 == 0)) {
                System.out.println("Fizz");
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
          
        

    }
}
