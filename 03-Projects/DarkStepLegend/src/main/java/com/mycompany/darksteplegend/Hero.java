/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

import com.mycompany.darksteplegend.Character;
import com.mycompany.darksteplegend.Enemy;
import static com.mycompany.darksteplegend.GameLogger.*;
import java.io.Serializable;

/**
 *
 * @author prashnamshrestha
 */
public class Hero extends Character implements Serializable{
    
    private int enemiesKilled = 0;
    private boolean shieldOn = false;
    private int mana;
    private int exp;
    private LevelType level = LevelType.BASIC;
            
    public Hero(String name, int maxHp, int gold, int passiveDmg, int skill2Dmg, int ultimateDmg) {
        
        super(name, maxHp, gold, passiveDmg, skill2Dmg, ultimateDmg);
        setMana(0);
        setExp(0);
    }
    
    public Hero(Hero template) {

        super(
            template.getName(),
            template.getMaxHp(),
            template.getGold(),
            template.getPassiveDmg(),
            template.getSkill2Dmg(),
            template.getUltimateDmg()
        );

        // Copy Hero-specific fields
        this.mana = template.mana;
        this.exp = template.exp;
        this.level = template.level;

        // Reset runtime state
        this.setCurrentHp(template.getMaxHp());
        this.setIsAlive(true);
        this.enemiesKilled = 0;
        this.shieldOn = false;
        this.exp = 0;
    }
    
        // METHODS
    public void rewardHero(Enemy enemy, Map map) {

        // ✅ REWARD EXP AND GOLD
        int goldReward = 0;
        int expReward = 0;

        switch (enemy.getEnemyType()) {
            case EASY -> { goldReward = 10; expReward = 15; }
            case MEDIUM -> { goldReward = 20; expReward = 40; }
            case HARD -> { goldReward = 50; expReward = 100; }
            case BOSS -> { goldReward = 200; expReward = 400; }
        }

        // Update hero stats
        this.setGold(this.getGold() + goldReward);
        this.setExp(this.getExp() + expReward);

        // Print reward
        printRewardHero(this, goldReward, expReward);

        // ✅ ITEM DROP BASED ON PHASE
        Item item = null;
        boolean itemGot = false;

        switch (map.getCurrentPhase()) {
            case SURVIVAL -> {
                if (Math.random() < 0.30) { item = map.getData().getGameAllItems().get(0); itemGot = true; }
            }
            case BLOODBATH -> {
                if (Math.random() < 0.40) { item = map.getData().getGameAllItems().get(1); itemGot = true; }
            }
            case SLAUGHTER -> {
                if (Math.random() < 0.70) { item = map.getData().getGameAllItems().get(2); itemGot = true; }
            }
            case EXTINCTION -> {
                item = map.getData().getGameAllItems().get(3);
                itemGot = true;
            }
        }

        if (itemGot && item != null) {
            this.addItem(item);
            printItemGained(item);
        }
    }
    
    public void useItem(Item item) {
        int effect = item.getItemEffect();
        
        if (item.getItemType() == ItemType.MANA_POTION) {
            this.mana+= effect;
        }
        else if (item.getItemType() == ItemType.MINOR_HP_POTION) {
            this.setCurrentHp(this.getCurrentHp() + effect);
        }
        else if (item.getItemType() == ItemType.SHIELD_SCROLL) {
            this.setShieldOn(true);
        }
        else if (item.getItemType() == ItemType.ELIXIR_OF_POWER) {
            this.setPassiveDmg(this.getPassiveDmg() + effect);
        }
    }
    
    
    public void showInventory() {
        
        System.out.println("\n  🎒 ==================== INVENTORY ==================== 🎒");
        System.out.printf("   💰 CURRENT BALANCE : %s Gold\n", this.getGold());
        System.out.printf("   ✨ ACCUMULATED EXP : %s XP\n", this.getExp());
        System.out.println("  ───────────────────────────────────────────────────────");
        System.out.println("   🧰 BACKPACK CONTENTS:");
        int i = 1;
        for (Item item: this.getInventory()) {
            System.out.printf("   [%s] %s\n", i, item.getItemInfo());
            i++;
        }
        System.out.println("  =======================================================");
    }
    
    public void addItem(Item item) { // Add ITEM HERO
        this.getInventory().add(item);  
    }
    
    public void removeItem(Item item) { // Remove ITEM
        this.getInventory().remove(item);
    }
    
    public void resetStatus() { // Reset STATUS OF HERO
        
        this.setCurrentHp(this.getMaxHp());
        this.setMana(0);
        this.setExp(0);
        this.setLevel(LevelType.BASIC);
        this.setIsAlive(true);
        this.setGold(0);
        this.getInventory().clear();
    }
    
    public boolean attack(Enemy enemy) { // Attack PASSIVE
        
        if (enemy.isIsAlive() && enemy.takeDamage(this.getPassiveDmg())) {
            this.enemiesKilled++;
            
        }
        this.mana += 10;
        return true; // Passive attack is always successful 
 
    }
    
    public boolean attack(Enemy enemy, AttackType type) { // Attack SKILL 2 OR ULTIMATE
        
        if (type == AttackType.SKILL2 && this.getMana() >= 20) {
            
            if (enemy.takeDamage(this.getSkill2Dmg())) {
                this.enemiesKilled++;
            }
            this.mana -=20;
            return true;
        }
        else if (type == AttackType.ULTIMATE && this.getMana() >= 30) {
            
            if (enemy.takeDamage(this.getUltimateDmg())) {
                this.enemiesKilled++;
            }
            
            this.mana -=30;
            return true;
        }
        return false;
    }
    
    public boolean takeDamage(int damage) { // Deal DAMAGE OF HERO
        
        if (!shieldOn) { // Only if shield is off
            
            this.setCurrentHp(this.getCurrentHp() - damage);
            
            if (this.getCurrentHp() <= 0) { 
                this.setCurrentHp(0);
                this.setIsAlive(false); 
                return true; // return dead
            }
            return false; // return alive
            
        }
        
        this.setShieldOn(false); // remove shield
        return false; // return alive
    }
    
    public void checkLevelUp() { // Upgrade LEVEL of HERO
        int currentDmg = this.getPassiveDmg();
        
        if (exp >= 60) {
            
            switch(getLevel()) {
                
                case (LevelType.BASIC):
                    
                    setLevel(LevelType.ELITE);;
                    System.out.printf("  📈 [PROMOTION] Rank Upgraded to: %s", LevelType.ELITE);
                    break;
                
                case (LevelType.ELITE):
                    
                    setLevel(LevelType.LEGEND);
                    System.out.printf("  📈 [ASCENSION] Rank Upgraded to: %s", LevelType.LEGEND);
                    break;
                
                default:
                    return;
                            
            }
            double damageIncrease = (double) currentDmg * 0.5;
            this.setPassiveDmg(currentDmg + (int) damageIncrease);
            System.out.printf(" | ✅ ATK BUMP: +%s DMG | 📉 EXP CONVERTED: -60\n", damageIncrease);
            exp -=60;
            
        }
    }
    

    public String getStatus() {
        return String.format("❤️ HP: %-4s | 🏅 LVL: %-7s | ☠️ KILLS: %-3s | 💧 MP: %-3s | ✨ EXP: %-4s | 👤 %s", 
                this.getCurrentHp(), this.getLevel(), this.getEnemiesKilled(), this.getMana(), this.getExp(), this.getName());
    }
    
    public String getMiniStatus() {
        return String.format("❤️ HP: %-4s | 💧 MP: %-3s | ✨ EXP: %-4s", 
                this.getCurrentHp(), this.getMana(), this.getExp());
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