/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.encapsulationtutorialquestion;

/**
 *
 * @author prashnamshrestha
 */
public class BankAccount {
    
    private int accountNumber;       
    private String accountHolderName;
    private double balance;
    
    public BankAccount(int number, String name, double bal) {
        setAccountNumber(number);
        setAccountHolderName(name);
        setBalance(bal);
    }
    
    public void withdraw(double amount) {
        
        if (amount < 0) {
            System.out.println("Negative balance!");
            return;
        }
        
        if (amount <= getBalance() ) {
        
            this.balance -= amount;
            System.out.printf("Amount withdrawn Rs %s | Bal : %s\n", amount, getBalance());
        }
        else {
            System.out.println("Not enough balance");
        }
        
    }
    
    public void deposit(double amount) {
        
         if (amount < 0) {
            System.out.println("Negative balance!");
            return;
        }
            this.balance += amount;
             System.out.printf("Amount deposited Rs %s | Bal : %s\n", amount, getBalance());

    }
    
    public double displayBalance() {
        
        return getBalance();
    }
    

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
}
