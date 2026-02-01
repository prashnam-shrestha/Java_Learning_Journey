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
    public void attack(GameCharacter target) {
        
        int damage = 20;
        target.takeDamage(damage);
        System.out.printf("%s smashes %s for 20 damage!\n", name, target.getName());
    }

   
            
}
