/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author prashnamshrestha
 */
public class GameData implements Serializable{
    
    private List<Player> gameAllPlayers;
    private List<Map> gameAllMaps;
    HashMap<EnemyType, List<Enemy>> gameAllEnemiesHM = new HashMap<>();
    private List<Hero> gameAllHeroes;
    private List<Item> gameAllItems;
    
    public GameData() {
        
        setGameAllPlayers(new ArrayList<>());
        setGameAllMaps(new ArrayList<>());
        setGameAllHeroes(new ArrayList<>());
        setGameAllItems(new ArrayList<>());
        
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
        Hero mage = new Hero("Mage", 250, 0, 10, 20, 30);
        Hero warrior = new Hero("Warrior", 300, 0, 15, 30, 50);
        Hero assassin = new Hero("Assassin", 180, 0, 25, 45, 90);
        Hero paladin = new Hero("Paladin", 450, 0, 12, 25, 40);
        Hero berserker = new Hero("Berserker", 220, 0, 30, 20, 70);
        Hero archmage = new Hero("Archmage", 200, 0, 10, 50, 100);
        
        addHero(mage);
        addHero(warrior);
        addHero(assassin);
        addHero(paladin);
        addHero(berserker);
        addHero(archmage);
        
        // 1. Easy Reward (Restores 50 HP)
        Item minorHpPotion = new Item("Minor HP Potion", ItemType.MINOR_HP_POTION, 50);

        // 2. Medium Reward (Restores 30 Mana)
        Item manaPotion = new Item("Mana Potion", ItemType.MANA_POTION, 30);

        // 3. Hard Reward (Gives 1 Shield - we use '1' to represent true or 1 charge)
        Item shieldScroll = new Item("Shield Scroll", ItemType.SHIELD_SCROLL, 1);

        // 4. Boss Reward (Adds +10 Permanent Damage)
        Item elixirOfPower = new Item("Elixir of Power", ItemType.ELIXIR_OF_POWER, 10);
        
        addItem(minorHpPotion);
        addItem(manaPotion);
        addItem(shieldScroll);
        addItem(elixirOfPower);
    }
    
    
    // METHODS
    public Hero getHeroFromData(int Index) {
        
        Hero template = this.getGameAllHeroes().get(Index);
        
        return new Hero(template); // Create copy of the Hero
    }
    
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
    
    public void addItem(Item item) {
        gameAllItems.add(item);
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

    public List<Item> getGameAllItems() {
        return gameAllItems;
    }

    public void setGameAllItems(List<Item> gameAllItems) {
        this.gameAllItems = gameAllItems;
    }
    
    
    
    
}
