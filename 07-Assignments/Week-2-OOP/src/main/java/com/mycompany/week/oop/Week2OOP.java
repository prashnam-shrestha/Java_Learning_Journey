/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week.oop;

/**
 *
 * @author prashnamshrestha
 */
public class Week2OOP {

    public static void main(String[] args) {
        // Question 1 and 2
        // Assing variable to each line
        
        String line1 = "Student A: Did you finish the Java Week 1 string print exercise?";
        String line2 = "Student B: Almost. I'm having trouble with quotes and backslashes.";
        String line3 = "Student A: You need to escape quotes using \\\" in Java strings.";
        String line4 = "Student B: So to print a quote, I should use double quotes with a backslash?";  
        String line5 = "Student A: Yes, exactly. Backslashes also need to be written as \\\\.";
        String line6 = "Student B: That makes sense. What about new lines and spacing?";
        String line7 = "Student A: Use \\n for a new line and \\t for tab spacing.";
        String line8 = "Student B: I tried that and the output looks much cleaner now.";
        String line9 = "Student A: Formatting is important, especially for exams.";
        String line10 = "Student B: True. One small mistake and the program won't run.";
        String line11 = "Student A: Practice a few more examples and it will become easy.";
        
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);
        System.out.println(line8);
        System.out.println(line9);
        System.out.println(line10);
        System.out.println(line11);
        System.out.println();
        
        
        
        // Question 3
        //Assigning a single variable
        
        String allLines = line1 + "\n" +
                                  line2 + "\n" +
                                  line3 + "\n" +
                                  line4 + "\n" +
                                  line5 + "\n" +
                                  line6 + "\n" +
                                  line7 + "\n" +
                                  line8 + "\n" +
                                  line9 + "\n" +
                                  line10 + "\n" +
                                  line11;
        System.out.println(allLines);
        
    }
        
}
