/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problemsolvinggemini2;

import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class ProblemSolvingGemini2 {

    public static void main(String[] args) {
        // Qn 4
        BankAccount prashnam = new BankAccount("Prashnam", 1000);
        prashnam.deposit(100.1);
        prashnam.withDraw(1100.2);
        prashnam.withDraw(1100);
        System.out.println(prashnam.getBalance());
        
        // Qn 5
        ArrayList<Student> classOne = new ArrayList<>();
        classOne.add(new Student("Prashnam", 99.99));
        classOne.add(new Student("Abnav", 18.0));
        classOne.add(new Student("Atrina", 99.0));
        
        int studentCount = classOne.size();
        
        int highScorerIndex = 0;
        for(int i = 0; i < studentCount; i++)  {
            if (classOne.get(i).getGrade() > classOne.get(highScorerIndex).getGrade()) {
                highScorerIndex = i;
            }
        }
        
        classOne.get(highScorerIndex).getInfo();
        
        
        // Qn 6
        Password p1 = new Password("atrina1P");
        System.out.println(p1.isValid(p1.getPassword()));
    }
}
