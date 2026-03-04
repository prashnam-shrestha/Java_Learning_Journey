/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class Category {
    private String nameCategory;
    private LocalDate date;
    
    public Category(String nameCategory, LocalDate date) {
        setNameCategory(nameCategory);
        setDate(date);
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
