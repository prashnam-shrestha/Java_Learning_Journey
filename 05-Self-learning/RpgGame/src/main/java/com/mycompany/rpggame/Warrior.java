/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpggame;

/**
 *
 * @author prashnamshrestha
 */
public class Warrior extends GameCharacter {
    
    private int shieldStrength;
    
    public Warrior(String name, int health, int shieldStrength) {
        super(name, health); // Using parent constructor
        this.shieldStrength = shieldStrength;
    }
    
    @Override
    public void attack() {
        System.out.printf("%s swings a heavy sword for 20 damage!\n", name);
    }
            
}
