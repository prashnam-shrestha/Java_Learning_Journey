/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab.section2;

/**
 *
 * @author prashnamshrestha
 */
public class Bill {
    int totalBill;
    int totalPerson;
    
    public Bill(int totalBill, int totalPerson) {
        this.totalBill = totalBill;
        this.totalPerson = totalPerson;
    }
    
    public void addtip(int percentage) {
        
        double addingValue= (double)totalBill * percentage/100;
        totalBill += addingValue;
   
        System.out.println("Added " + percentage + "% tip.");
    }
    
    public void calculatebill() {
        System.out.println("Each person gets: " + totalBill/totalPerson);
    }
    
}
