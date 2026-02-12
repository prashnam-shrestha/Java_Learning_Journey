/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

/**
 *
 * @author prashnamshrestha
 */
public class Dvd extends LibraryItem {
    private String title;
    private String creator;
    private int durationMin;
    
    public Dvd(String title, String creator, int duration) {
        super(Type.DVD, title);
        setCreator(creator);
        setDurationMin(duration);
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }
    
    
}
