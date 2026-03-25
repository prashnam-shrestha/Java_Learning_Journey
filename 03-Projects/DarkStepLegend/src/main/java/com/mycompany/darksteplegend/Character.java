/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public abstract class Character implements Serializable{
    
    private String name;
    private int maxHp;
    private int currentHp;
    private int gold;
    private int passiveDmg;
    private int skill2Dmg;
    private int ultimateDmg;
    private boolean isAlive = true;
    private List<Item> inventory;
    
    public Character(String name, int maxHp, int gold, int passiveDmg, int skill2Dmg, int ultimateDmg) {
        
        setName(name);
        setMaxHp(maxHp);
        setCurrentHp(maxHp);
        setInventory(new ArrayList<>());
        setGold(gold);
        setPassiveDmg(passiveDmg);
        setSkill2Dmg(skill2Dmg);
        setUltimateDmg(ultimateDmg); 
        
    }
    // ABSTRACT METHODS
    
    public abstract boolean takeDamage(int damage); // Damage DEALT
    
    public abstract void resetStatus(); // Reset STATUS
    
    public abstract void addItem(Item item); // Add ITEM
    
    public abstract String getStatus(); // Get STATUS
    
    
    // GETTERS AND SETTERS

    public int getPassiveDmg() {
        return passiveDmg;
    }

    public void setPassiveDmg(int passiveDmg) {
        this.passiveDmg = passiveDmg;
    }

    public int getSkill2Dmg() {
        return skill2Dmg;
    }

    public void setSkill2Dmg(int skill2Dmg) {
        this.skill2Dmg = skill2Dmg;
    }

    public int getUltimateDmg() {
        return ultimateDmg;
    }

    public void setUltimateDmg(int ultimateDmg) {
        this.ultimateDmg = ultimateDmg;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public List<Item> getInventory() {
        return inventory;
    } 

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    
}
