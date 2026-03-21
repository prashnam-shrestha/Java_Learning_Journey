package com.mycompany.darksteplegends;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    
    private String name;
    private int hp;
    private int maxHp;
    private int passiveDmg;
    private int ultimateEffect;
    private boolean isAlive = true;
    private int gold;
    private int exp;
    private List<Item> inventory;
    
    public Character(String name, int hp, int passiveDmg, int ultimateEffect) {
        setName(name);
        setHp(hp);
        setMaxHp(hp);
        setPassiveDmg(passiveDmg);
        setUltimateEffect(ultimateEffect);
        setGold(50);
        setExp(20);
        setInventory(new ArrayList<>());
    }
    
    public void dealtDamage(int dmg) {
        this.setHp(getHp() - dmg); 

        if (this.getHp() <= 0) {
            this.setHp(0);
            this.isAlive = false;
            System.out.println("☠️  " + this.getName() + " has been defeated!");
        }
    }
    
    public void passiveAttack(Character target)  {
        if (!isAlive || !(target.isAlive)) {
            return;
        }
            
        target.dealtDamage(this.getPassiveDmg());
        System.out.printf("⚔️  [COMBAT] %s attacked %s for %s damage!\n", this.getName(), target.getName(), this.getPassiveDmg());
    }
    
    public void addItemInventory(Item item) {
        inventory.add(item);
    }
    
    public void removeItem(Item item) {
        inventory.remove(item);
    }
    
    public abstract void rewardWinner(Character from);
     
    // Getters and Setters
    public List<Item> getInventory() { return inventory; }
    public void setInventory(List<Item> inventory) { this.inventory = inventory; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getPassiveDmg() { return passiveDmg; }
    public void setPassiveDmg(int passiveDmg) { this.passiveDmg = passiveDmg; }
    public int getUltimateEffect() { return ultimateEffect; }
    public void setUltimateEffect(int ultimateEffect) { this.ultimateEffect = ultimateEffect; }
    public boolean isIsAlive() { return isAlive; }
    public void setIsAlive(boolean isAlive) { this.isAlive = isAlive; }
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }
    public int getExp() { return exp; }
    public void setExp(int exp) { this.exp = exp; }
    public int getMaxHp() { return maxHp; }
    public void setMaxHp(int maxHp) { this.maxHp = maxHp; }
}