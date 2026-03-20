/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegends;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public abstract class Character {
    
    private String name;
    private int hp;
    private int passiveDmg;
    private int ultimateEffect;
    private boolean isAlive = true;
    private int gold;
    private int exp;
    private List<Item> inventory;
    
    public Character(String name, int hp, int passiveDmg, int ultimateEffect) {
        
        setName(name);
        setHp(hp);
        setPassiveDmg(passiveDmg);
        setUltimateEffect(ultimateEffect);
        setGold(50);
        setExp(0);
        setInventory(new ArrayList<>());
    }
    
    // Methods
    
    // Deal damages
    public void dealtDamage(int dmg) {
        
        this.setHp(getHp() - dmg); 

        if (this.getHp() <= 0) {
            this.setHp(0);
            this.isAlive = false;
            System.out.println(this.getName() + " is dead!");
        }
            
    }
    
    // Attack with passive
    public void passiveAttack(Character target)  {
        
        if (!isAlive) {
            System.out.println("Cant attack by dead");
            return;
        }
            
        target.dealtDamage(getPassiveDmg());
        System.out.printf("%s attack %s, hp remain: %s.\n", this.getName(), target.getName(), target.getHp());

        if (!(target.isAlive)) {
            this.rewardWinner(target);
         }
        
    }
    
    // Heal itself
    public void healHp(int amount) {
        
        System.out.printf("%s healed hp.\n", this.getName());
        setHp(getHp() + amount);
    }
    
    // Add and remove items
    public void addItemInventory(Item item) {
        inventory.add(item);
    }
    
    public void removeItem(Item item) {
        inventory.remove(item);
    }
    
    public abstract void rewardWinner(Character from);
     
    
    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPassiveDmg() {
        return passiveDmg;
    }

    public void setPassiveDmg(int passiveDmg) {
        this.passiveDmg = passiveDmg;
    }

    public int getUltimateEffect() {
        return ultimateEffect;
    }

    public void setUltimateEffect(int ultimateEffect) {
        this.ultimateEffect = ultimateEffect;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    
    
    
    
    
}
