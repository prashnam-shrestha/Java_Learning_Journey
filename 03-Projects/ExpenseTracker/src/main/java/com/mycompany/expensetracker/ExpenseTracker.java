/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expensetracker;

import static com.mycompany.expensetracker.Utility.*;
import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class ExpenseTracker {

    public static void main(String[] args) {
        
        User u = new User("Prashnam");
        Wallet wal = new Wallet("Esewa", 1000);
//        
        Category cSalary = new Category("Salary", CashFlowType.INCOME);
        Category cFood = new Category("Food", CashFlowType.EXPENSE);
//        Expense exp = new Expense("Momo", 1000, cFood, wal);
//        Income inc = new Income("Salary", 1000, cSalary, wal);
//        
        u.addCategory(cFood);
        u.addWallet(wal);
//        
//        // Add expense
//        boolean runCode = u.addExpense(exp);
//        
//        if (!runCode) {
//            System.out.println("NO enough balance to add expense");
//        }
//        else {
//            System.out.println("Expense added successfully");;
//        }
//        
//        // Add income
//        u.addIncome(inc);
//        
//        
//        
//        // General info
//        
//        
//        displayMainMenu(u);
//        displayWalletMenu(u);
//        displayCategoryMenu(u);
//        displayCashFlow(u);
        
        // Application 
        boolean run = true;
        while (run) {
            
            displayMainMenu(u);
            int choice = getValidInt("Enter choice: "); 
            switch (choice) {
                
                // Add expenses
                case 1:
                    
                    int categoryCount = displayAvailabeCategory(u);
                    
                    // Add Expenses Confirm
                    if (categoryCount > 0) {
                        
                        addExpenseOperation(u, categoryCount);
                                
                    }
                    else {
                        System.out.println("Not enought Category! Please create them to add Expenses");
                    }
                    break;
                
                // Delete expense 
                case 2:
                    
                    // Check if the list is empty;
                    int expenseCount = u.getAppState().getExpenses().size();
                    if (expenseCount == 0) {
                        
                        System.out.println("No expenses created yet!");
                        break;
                    }
                        deleteExpenseOperation(u, expenseCount);
                    
                    break;
                  
                // Manage Wallet
                case 3:
                    
                    break;
                
                 
                // Manage Category
                case 4:
                    
                    break;
                
                // Report Cashflow
                case 5:
                    
                    break;
                
                    
                case 6:
                    run = false;
                    System.out.println("Exiting the program!");
                    break;
                
                default:
                    System.out.println("Optin not found!");
                            
            }
        }
        
        // Temporary
        for (Expense e : u.getAppState().getExpenses()) {
             System.out.println(e.getCashFlowInfo());
        }
        for (Transaction t : u.getAppState().getTransaction()) {
             System.out.println(t.getDetail());
        }
        for (Wallet w : u.getAppState().getWallet()) {
             System.out.println(w.getDetail());
        }
        
    }
         
}
