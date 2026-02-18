/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apexcapitalbank;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */


public abstract class Account {
    
    private int accountNo;
    private int accountPin;
    private double balance;
    private boolean freeze;
    
    // Transactions
    private ArrayList<Transaction> transactions = new ArrayList<>();
    
    public Account(double balance) {
        
        setBalance(balance);
        setAccountNo(getNewAccountNum());
        setAccountPin(getNewPinNum());
        

    }
    // ------ Methods --------
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("  [!] Error: Invalid amount entered.");
            return;
        }
        this.balance += amount;
        Transaction tran = new Transaction(amount, transactionType.DEPOSIT, this, LocalDate.now());
        addTransaction(tran);
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
        
        if (getBalance() >= amount) {
            this.balance -= amount;
            Transaction tran2 = new Transaction(amount, transactionType.WITHDRAW, this, LocalDate.now());
            addTransaction(tran2);
        }
    }
    
    public void transferBal(double amount, Account receiver) {
        if (isFreeze()) {
            System.out.println("  [!] Alert: Account is Frozen. Operation Failed.");
            return;
        }
        else if (amount < 0) {
            System.out.println("  [!] Error: Invalid amount entered.");
            return;
        }
        
        if (getBalance() >= amount) {
            this.balance -= amount;
            receiver.deposit(amount);
            Transaction tran3 = new Transaction(amount, transactionType.TRANSFER, receiver, LocalDate.now());
            addTransaction(tran3);
        }
    }
    
    public abstract void performEOM();
    
    public abstract String getAccInfo();
    
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    
    public void getAccountTransactions() {
        System.out.printf("\n------- TRANSACTION HISTORY (ACC: %s) ------\n", getAccountNo());
        for (Transaction t: getTransactions()) {
            System.out.println(t.getInfoTransaction());
        }
        System.out.println("----------------------------------------------");
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean isFreeze() {
        return freeze;
    }

    public void setFreeze(boolean freeze) {
        this.freeze = freeze;
    }
    
    public static int accountNumberGenerated = 1000;

    public static int accountPinGenerated = 100;

    public static int getNewAccountNum() {
        accountNumberGenerated ++;
        return accountNumberGenerated;
    }

    public static int getNewPinNum() {
        accountPinGenerated ++;
        return ((int)(Math.random() * 900) + 100) + accountPinGenerated;
    }

}
