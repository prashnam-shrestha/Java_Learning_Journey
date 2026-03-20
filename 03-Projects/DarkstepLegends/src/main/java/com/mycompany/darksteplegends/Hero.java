/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegends;

/**
 *
 * @author prashnamshrestha
 */
public class Hero extends Character {
    
    private int mana;
    private int level;
    private boolean shieldOn;
    
    public Hero(String name, int hp, int passiveDmg, int ultimateEffect) {
        
        super(name, hp, passiveDmg, ultimateEffect);
        
        setLevel(1);
    }
    
    // Methods
    @Override
    public void dealtDamage(int dmg) {
        
        if (shieldOn) {
            // Print shield protected
            setShieldOn(false);
            return;
        }
        
        if (isIsAlive()) {
            setHp(getHp() - dmg);
            System.out.printf("%s dealt damage.\n", this.getName());
            
        }
        
        if (this.getHp() <= 0) {
            this.setHp(0);
            this.setIsAlive(false);
            System.out.println(this.getName() + " is dead!");
        }
        // Print char is dead
    }
    
    public void passiveAttack(Character target)  {
        
        if (!this.isIsAlive()) {
            System.out.println("Cant attack by dead");
            return;
        }
            
        target.dealtDamage(getPassiveDmg());
        mana+= 20;
        System.out.printf("%s attack %s, hp remain: %s.\n", this.getName(), target.getName(), target.getHp());

        if (!(target.isIsAlive())) {
            this.rewardWinner(target);
         }
        
        
    }
    
    // User Ultimate
    public void useUltimate(Character target) {
        if (mana >= 50) {
            
            target.dealtDamage(getUltimateEffect());
            
            System.out.printf("%s attack %s, hp remain: %s.\n", this.getName(), target.getName(), target.getHp());
            mana-= 50;
            
            if (!(target.isIsAlive())) {
                this.rewardWinner(target);
             }
            return;
        }
        System.out.println("Not enough mana to use ulimate");
        
    }
    
    public boolean showInventory() {
        if (this.getInventory().size() == 0) {
            System.out.println("Empty inventory");
            return false;
        }
        int num = 1;
        for (Item i: this.getInventory()){
            System.out.printf(num + ". ");
            System.out.println(i.getName());
            num++;
        }
        return true;
    }
    // Earn gold
    public void earnGold(int amount) {
        
        setGold(getGold() + amount);
    }
    
    // Use item by hero
    public void useItem(int itemNum, Enemy target) {
        Item item = getInventory().get(itemNum);
        item.useItem(target, this);
        this.removeItem(item);
    }
    
    // Reward winner after death
    public void rewardWinner(Character from) {
        
        for (Item i: from.getInventory()) {
            
            this.addItemInventory(i);
            System.out.println(this.getName() + " got " + i.getName());
        }
        
            
        this.earnGold(from.getGold());
        System.out.println(this.getName() + " earned gold " + from.getGold());
        
        from.getInventory().clear();
        
        
    }
    
    
    // Getters and Setters

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isShieldOn() {
        return shieldOn;
    }

    public void setShieldOn(boolean shieldOn) {
        this.shieldOn = shieldOn;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    
    
    
    
    
}
