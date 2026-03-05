/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expensetracker;

/**
 *
 * @author prashnamshrestha
 */
public class ExpenseTracker {

    public static void main(String[] args) {
        
        User u = new User("Prashnam");
        Wallet wal = new Wallet("Esewa", 1000);
        
        Category cSalary = new Category("Salary", CashFlowType.INCOME);
        Category cFood = new Category("Food", CashFlowType.EXPENSE);
        Expense exp = new Expense("Momo", 1000, cFood, wal);
        Income inc = new Income("Salary", 1000, cSalary, wal);
        
        u.addCategory(cFood);
        u.addWallet(wal);
        
        // Add expense
        boolean runCode = u.addExpense(exp);
        
        if (!runCode) {
            System.out.println("NO enough balance to add expense");
        }
        else {
            System.out.println("Expense added successfully");;
        }
        
        // Add income
        u.addIncome(inc);
        
        
        
        // General info
        
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
