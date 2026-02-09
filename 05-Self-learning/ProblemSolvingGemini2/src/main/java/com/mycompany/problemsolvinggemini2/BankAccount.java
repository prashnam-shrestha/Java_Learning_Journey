/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problemsolvinggemini2;

/**
 *
 * @author prashnamshrestha
 */
public class BankAccount {
    private double balance;
    private String name;
    
    public BankAccount(String name, double balance) {
        setBalance(balance);
        setName(name);
    }
    
    public void withDraw(double amount) {
        if (amount <= getBalance()) {
            this.balance -= amount;
            System.out.printf("Withdrawn amount %s\n", amount);
        }
        else {
            System.out.println("No enough balance");
        }
    }
    
    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Amount %s deposited\n", amount);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
