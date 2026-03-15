/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.encapsulationtutorialquestion;

/**
 *
 * @author prashnamshrestha
 */
public class EncapsulationTutorialQuestion {

    public static void main(String[] args) {
       
        // Q1
        Student s1 = new Student("IIMS0151", "Prashnam Shrestha", 100);
        System.out.println(s1.displayStudentDetails());
        
        // Q2
        BankAccount a1 = new BankAccount(100, "Prashnam", 1000);
        a1.withdraw(10000);
        a1.deposit(100000);
        a1.withdraw(10000);
        System.out.println(a1.getBalance());
        
        //Q3
        Employee e1 = new Employee("100", "Prashnam", 100);
        
        
    }
}
