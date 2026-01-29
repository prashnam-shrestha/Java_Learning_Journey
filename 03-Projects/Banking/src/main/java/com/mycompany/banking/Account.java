/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banking;

/**
 *
 * @author prashnamshrestha
 */
public class Account {
    // User 
    private String accHolderName;
    private double balance;
    
    private static int customerCount = 0;
    private static double bankAssets = 0;
    
    public Account(String name, double amount) {
        System.out.printf("Account created by %s\n", name);
        setAccHolderName(name);
        setBalance(amount);
        customerCount++;
        
    }

    // Getters and Setters
    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        if (amount < 500) {
            System.out.println("Can't start with less then Rs 500.\n");
        }
        else {
            this.deposit(amount);
        }
    }

    public static double getBankAssets() {
        return bankAssets;
    }

    public static void setBankAssets(double amount) {
        Account.bankAssets += amount;
    }
    
    public static int getCustomerCount() {
        return customerCount;
    }
    
    // Methods
    public String getAccountInfo() {
        String information = String.format("%s balance: Rs %s", accHolderName, balance );
        return information;
    }
    
    public void deposit(double amount) {
        if (amount < 10) {
            System.out.println("Can't deposit less then Rs 10.\n");
        }
        else {
            balance += amount;
            setBankAssets(amount);
            System.out.printf("%s deposited Rs %s.\n",accHolderName, amount);
        }
    }
    
    public void withdraw(double amount) {
        if ((amount <= this.getBalance()) && amount > 10) {
            balance -= amount;
            Account.bankAssets -= amount;
            System.out.printf("%s withdrawn Rs %s.\n",accHolderName, amount);
        }
        else {
            System.out.println("Withdrawn failed, Please try again!\n");
        }
    }
    public void transferBalance(Account who, double amount) {

        if ((amount <= this.getBalance()) && (amount > 100)) {
            this.withdraw(amount);
            who.deposit(amount);
            System.out.printf("%s transfered Rs %s to %s.\n",accHolderName, amount, who.getAccHolderName());
        }
        else {
            System.out.println("Transfer failed, Please try again!");
        }
    }
    
    
}
