/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

/**
 *
 * @author prashnamshrestha
 */
public class Hero extends Character{
    
    private int enemiesKilled = 0;
    private boolean shieldOn;
    private int mana;
    private int exp;
    private LevelType level = LevelType.BASIC;
            
    public Hero(String name, int maxHp, int gold, int passiveDmg, int skill2Dmg, int ultimateDmg) {
        
        super(name, maxHp, gold, passiveDmg, skill2Dmg, ultimateDmg);
        setMana(0);
        setExp(0);
    }
    
    // METHODS
    public void resetStatus() { // Reset STATUS OF HERO
        
        this.setCurrentHp(this.getMaxHp());
        this.setMana(0);
        this.setExp(0);
        this.setLevel(LevelType.BASIC);
        this.setIsAlive(true);
        this.setGold(0);
        this.getInventory().clear();
    }
    
    public void attack(Enemy enemy) { // Attack PASSIVE
        
        if (enemy.isIsAlive() && enemy.takeDamage(this.getPassiveDmg())) {
            this.enemiesKilled++;
        }
 
    }
    
    public void attack(Enemy enemy, AttackType type) { // Attack SKILL 2 OR ULTIMATE
        
        if (type == AttackType.SKILL2 && enemy.takeDamage(this.getSkill2Dmg())) {
            this.enemiesKilled++;
        }
        else if (type == AttackType.ULTIMATE && enemy.takeDamage(this.getUltimateDmg())) {
            this.enemiesKilled++;
        }
    }
    
    public boolean takeDamage(int damage) { // Deal DAMAGE OF HERO
        
        if (!shieldOn) { // Only if shield is off
            
            this.setCurrentHp(this.getCurrentHp() - damage);
            
            if (this.getCurrentHp() <= 0) { 
                
                this.setIsAlive(false); 
                return false; // return dead
            }
            return true; // return alive
            
        }
        
        this.setShieldOn(false); // remove shield
        return true; // return alive
    }
    
    public void checkLevelUp() { // Upgrade LEVEL of HERO
        int currentDmg = this.getPassiveDmg();
        
        if (exp >= 60) {
            
            switch(getLevel()) {
                case (LevelType.BASIC):
                    
                    setLevel(LevelType.ELITE);
                    this.setPassiveDmg(currentDmg + (currentDmg * (5/100)));
                    exp -=60;
                    break;
                
                case (LevelType.ELITE):
                    
                    setLevel(LevelType.LEGEND);
                    this.setPassiveDmg(currentDmg + (currentDmg * (5/100)));
                    exp -=60;
                    break;
                
                default:
                    break;
                            
            }
        }
    }
    
    // GETTERS AND SETTERS

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public LevelType getLevel() {
        return level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }
    
}
