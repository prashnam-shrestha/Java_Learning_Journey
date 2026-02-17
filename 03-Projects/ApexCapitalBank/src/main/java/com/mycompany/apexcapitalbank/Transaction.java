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
public class Transaction {
    private transactionType type;
    private LocalDate date;
    private Account receiver;
    private double amount;
    
    public Transaction(double amount, transactionType type, Account receiver, LocalDate date) {
        setType(type);
        setAmount(amount);
        setReceiver(receiver);
        setDate(date);
    }
    
    public String getInfoTransaction() {
        if (getType() == transactionType.DEPOSIT) {
            return String.format("  [+] Deposit:    Rs %s  | Date: %s", getAmount(), getDate());
        }
        else if (getType() == transactionType.WITHDRAW) {
            return String.format("  [-] Withdrawal: Rs %s  | Date: %s", getAmount(), getDate());
        }
        else if (getType() == transactionType.TRANSFER) {
            return String.format("  [>] Transfer:   Rs %s  | To: %s | Date: %s", getAmount(), getReceiver().getAccountNo() , getDate());
        }
        else {
            return String.format("  [%] Interest:   Rs %s  | Date: %s", getAmount(), getDate());
        }
    }

    public transactionType getType() {
        return type;
    }

    public void setType(transactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
    
    
    
}