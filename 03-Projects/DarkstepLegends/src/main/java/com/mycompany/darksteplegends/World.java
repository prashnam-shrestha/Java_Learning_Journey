package com.mycompany.darksteplegends;

import java.util.ArrayList;
import java.util.List;

public class World {
    
    private String name;
    private List<Enemy> enemies;
    private int rewardGold;
    private int phase = 1;
    private int finalPhase = 8;
    
    public World(String name, int rewardGold) {
        setName(name);
        setRewardGold(rewardGold);
        setEnemies(new ArrayList<>());
    }
    
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public boolean increasePhase() {
        if (phase == finalPhase) {
            System.out.println("\n🏆🏆🏆 WORLD CLEARED! 🏆🏆🏆");
            System.out.println("Congratulations, you have conquered " + this.getName() + "!");
            return false;
        }
        phase++;
        return true;
    }
    
    public void resetWorld() {
        for (Enemy e: enemies) {
            e.setHp(e.getMaxHp());
            e.setIsAlive(true);
        }
        System.out.println("🔄 [WORLD] " + this.getName() + " has been reset.");
    }
    
    public int getPhase() { return phase; }
    public void setPhase(int phase) { this.phase = phase; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Enemy> getEnemies() { return enemies; }
    public void setEnemies(List<Enemy> enemies) { this.enemies = enemies; }
    public int getRewardGold() { return rewardGold; }
    public void setRewardGold(int rewardGold) { this.rewardGold = rewardGold; }
}