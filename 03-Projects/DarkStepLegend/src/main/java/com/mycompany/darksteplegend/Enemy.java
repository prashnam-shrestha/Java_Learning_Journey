/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

import java.io.Serializable;

/**
 *
 * @author prashnamshrestha
 */
public class Enemy extends Character implements Serializable{
    
    private int attackCount = 0;
    private int exp;
    private EnemyType enemyType;
    
    public Enemy(String name, int maxHp, int gold, int passiveDmg, int skill2Dmg, int ultimateDmg, EnemyType type) {
        
        super(name, maxHp, gold, passiveDmg, skill2Dmg, ultimateDmg);
        setExp(10);
        setEnemyType(type);
    }    
    
    // Inside Enemy.java    
    public Enemy(Enemy template) {
        // Call super with all the values from template
        super(
            template.getName(),
            template.getMaxHp(),
            template.getGold(),
            template.getPassiveDmg(),
            template.getSkill2Dmg(),
            template.getUltimateDmg()
        );

        // Copy Enemy-specific fields
        this.enemyType = template.enemyType;
        this.exp = template.exp;

        // Important: reset runtime state (don't copy currentHp, isAlive, attackCount!)
        this.setCurrentHp(template.getMaxHp());
        this.setIsAlive(true);// full health
        this.attackCount = 0;
    }
    
    // METHODS
    public String getStatus()  {
        return String.format("HP: %s | DIFFICULTY: %s | NAME: %s \n", 
                this.getCurrentHp(),this.getEnemyType(), this.getName());
    }
    
    public String getMiniStatus() {
        return String.format("HP: %s | NAME: %s \n", 
                this.getCurrentHp(), this.getName());
    }
    
    public void addItem(Item item) { // Add ITEM ENEMY
        this.getInventory().add(item);  
    }
    
    public void resetStatus() { // Reset STATUS OF ENEMY
        
        this.setCurrentHp(this.getMaxHp());
        this.setIsAlive(true);
    }
    
    public int getRightAttack() { // GET VERITY OF ATTACKS
        EnemyType type = getEnemyType();

        attackCount++;

        if (type == EnemyType.EASY) {
            return getPassiveDmg();
        }
        else if (type == EnemyType.MEDIUM && attackCount % 3 == 0 && Math.random() < 0.7) {
            return getSkill2Dmg(); // 70% chance
        }
        else if (type == EnemyType.MEDIUM) {
            return getPassiveDmg();
        }
        else if (type == EnemyType.HARD && attackCount % 4 == 0 && Math.random() < 0.6) {
            return getUltimateDmg(); // 60% chance
        }
        else if (type == EnemyType.HARD) {
            return getPassiveDmg();
        }
        else if (type == EnemyType.BOSS && attackCount % 2 == 0 && Math.random() < 0.8) {
            return getUltimateDmg(); // 80% chance
        }
        else {
            return getPassiveDmg();
        }
    }
    
    public AttackType attack(Hero hero) { // Attack PASSIVE
        
        if (!hero.isIsAlive()) {
            return null;
        }
        
        int damage = getRightAttack();

        hero.takeDamage(damage);
        
        if (damage > this.getSkill2Dmg()) {
            return AttackType.ULTIMATE;
        }
        else if (damage > this.getPassiveDmg()) {
            return AttackType.SKILL2;
        }
        return AttackType.PASSIVE;
 
    }
    
    public boolean takeDamage(int damage) {
        
        this.setCurrentHp(this.getCurrentHp() - damage);

        if (this.getCurrentHp() <= 0) { 
            this.setCurrentHp(0);
            this.setIsAlive(false); 
            return true; // return dead
        }
        return false; // return alive
    }
    
    // GETTERS AND SETTERS

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(EnemyType enemyType) {
        this.enemyType = enemyType;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    
}