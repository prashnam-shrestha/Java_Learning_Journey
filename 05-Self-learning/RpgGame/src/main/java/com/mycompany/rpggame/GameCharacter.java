/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpggame;

/**
 *
 * @author prashnamshrestha
 */
public class GameCharacter {
    protected String name;
    protected int health;
    
    // Constructor
    public GameCharacter(String name, int health) {
        setName(name);
        setHealth(health);
    }

    // Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    // Methods
    public void attack() {
        System.out.printf("%s performs a basic attack\n", name);
    }
    
    public void takeDamage(int amount) {
        health -= amount;
        System.out.printf("%s took a %s damage. Health is now %s\n", name, amount, health);
    }
    
}
