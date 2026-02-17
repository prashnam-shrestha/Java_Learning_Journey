/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apexcapitalbank;

import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class LoanAccount extends Account{
    
    private double interestRate;
    
    public LoanAccount(double balance, double rate) {
        super(balance);
        setInterestRate(rate);
    }
    
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("  [!] Error: Invalid amount entered.");
            return;
        }
        if (amount <= getBalance()) {
            
            this.setBalance(getBalance() - amount);
            Transaction tran = new Transaction(amount, transactionType.DEPOSIT, this, LocalDate.now());
            addTransaction(tran);
        }
        else {

            double depositReal = getBalance();
            this.setBalance(0);
            Transaction tran = new Transaction(depositReal, transactionType.DEPOSIT, this, LocalDate.now());
            System.out.printf("  [!] Notice: Excess amount returned (Rs %s). Loan fully paid!\n", (amount - depositReal));
            addTransaction(tran);
        }

    }
    
    public void withdraw(double amount) {
        if (isFreeze()) {
            System.out.println("  [!] Alert: Account is Frozen. Operation Failed.");
            return;
        }
        else if (amount < 0) {
            System.out.println("  [!] Error: Invalid amount entered.");
            return;
        }
        
        if ((getBalance() + amount) <= 2000000) {

            this.setBalance(getBalance() + amount);
            Transaction tran2 = new Transaction(amount, transactionType.WITHDRAW, this, LocalDate.now());
            addTransaction(tran2);
        }
    }
    
    public void transferBal(double amount) {
        System.out.println("  [!] Warning: Cannot transfer balance from a Loan Account.");
    }
    
    public void performEOM() {
        double balance = getBalance();
        double interestAmt = balance * (interestRate/100);
        setBalance(balance + interestAmt);
        
        Transaction tran = new Transaction(interestAmt, transactionType.INTEREST, this, LocalDate.now());
        addTransaction(tran);
    }
    
    public String getAccInfo() {
        return String.format("  > [LN]  Outstanding Loan: Rs %s", getBalance());
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
    
    
    
}