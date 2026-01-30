/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpggame;

import java.io.PrintStream;

/**
 *
 * @author prashnamshrestha
 */
public class Mage extends GameCharacter {
    private int mana;
    
    public Mage(String name, int health, int mana) {
        super(name, health);// Using parent constructor
        this.mana = mana;
    }
    
    @Override
    public void attack() {
        System.out.printf("%s casts a Fireball for 40 damage!\n", name);
    }
    
}
