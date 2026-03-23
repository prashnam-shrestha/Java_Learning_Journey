/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author prashnamshrestha
 */
public class GameData {
    
    private List<Player> gameAllPlayers;
    private List<Map> gameAllMaps;
    HashMap<EnemyType, List<Enemy>> gameAllEnemiesHM = new HashMap<>();
    private List<Hero> gameAllHeroes;
    
    public GameData() {
        
        setGameAllPlayers(new ArrayList<>());
        setGameAllMaps(new ArrayList<>());
        setGameAllHeroes(new ArrayList<>());
        
        // Easy enemies
        List<Enemy> easyEnemies = new ArrayList<>();
        List<Enemy> mediumEnemies = new ArrayList<>();
        List<Enemy> hardEnemies = new ArrayList<>();
        List<Enemy> bossEnemies = new ArrayList<>();
        
        // parameters: name, maxHp, gold, passiveDmg, skill2Dmg, ultimateDmg, type

        // 🟢 EASY
        easyEnemies.add(new Enemy("Mini Goblin", 60, 10, 15, 20, 30, EnemyType.EASY));
        easyEnemies.add(new Enemy("Bone Witch", 70, 15, 18, 20, 30, EnemyType.EASY));
        easyEnemies.add(new Enemy("Mini peka", 70, 15, 18, 20, 30, EnemyType.EASY));


        // 🟡 MEDIUM
        mediumEnemies.add(new Enemy("Shadow Hound", 110, 30, 35, 40, 50, EnemyType.MEDIUM));
        mediumEnemies.add(new Enemy("Iron Goblin", 130, 25, 30, 35, 45, EnemyType.MEDIUM));
        mediumEnemies.add(new Enemy("Kings Slayer", 180, 25, 35, 40, 65, EnemyType.MEDIUM));


        // 🔴 HARD
        hardEnemies.add(new Enemy("Xavier", 120, 50, 70, 40, 80, EnemyType.HARD));
        hardEnemies.add(new Enemy("Goblin Warlord", 350, 60, 65, 30, 80, EnemyType.HARD));
        hardEnemies.add(new Enemy("MountainGod", 400, 50, 50, 40, 70, EnemyType.HARD));


        // 👑 BOSS
        bossEnemies.add(new Enemy("Shadow Emperor", 900, 100, 90, 60, 100, EnemyType.HARD));
        

        // Add to the AllEnemies Section
        gameAllEnemiesHM.put(EnemyType.EASY, easyEnemies);
        gameAllEnemiesHM.put(EnemyType.MEDIUM, mediumEnemies);
        gameAllEnemiesHM.put(EnemyType.HARD, hardEnemies);
        gameAllEnemiesHM.put(EnemyType.BOSS, bossEnemies);
        
        // All heros
        Hero hero = new Hero("Mage", 250, 0, 10, 20, 30);
        addHero(hero);
    }
    
    
    // METHODS
    public Enemy getEnemyFromData(EnemyType type) {
        
        List<Enemy> templates = gameAllEnemiesHM.get(type);
        if (templates == null || templates.isEmpty()) {
        return null; // or throw exception
        }
        Enemy template = templates.get(new Random().nextInt(templates.size()));
        
        return new Enemy(template); // Create copy of the enemy
    }
    
    public void addPlayer(Player player) { // Add Player
        gameAllPlayers.add(player);
    }

    // Add Map
    public void addMap(Map map) {
        gameAllMaps.add(map);
    }

    // Add Hero
    public void addHero(Hero hero) {
        
        gameAllHeroes.add(hero);
    }
    
    // GETTERS AND SETTERS

    public List<Player> getGameAllPlayers() {
        return gameAllPlayers;
    }

    public void setGameAllPlayers(List<Player> gameAllPlayers) {
        this.gameAllPlayers = gameAllPlayers;
    }

    public List<Map> getGameAllMaps() {
        return gameAllMaps;
    }

    public void setGameAllMaps(List<Map> gameAllMaps) {
        this.gameAllMaps = gameAllMaps;
    }

    public HashMap<EnemyType, List<Enemy>> getGameAllEnemiesHM() {
        return gameAllEnemiesHM;
    }

    public void setGameAllEnemiesHM(HashMap<EnemyType, List<Enemy>> gameAllEnemiesHM) {
        this.gameAllEnemiesHM = gameAllEnemiesHM;
    }

    public List<Hero> getGameAllHeroes() {
        return gameAllHeroes;
    }

    public void setGameAllHeroes(List<Hero> gameAllHeroes) {
        this.gameAllHeroes = gameAllHeroes;
    }
    
    
}
