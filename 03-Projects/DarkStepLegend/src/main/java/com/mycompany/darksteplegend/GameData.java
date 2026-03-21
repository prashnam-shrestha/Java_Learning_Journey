/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class GameData {
    
    private List<Player> gameAllPlayers;
    private List<Map> gameAllMaps;
    private List<Enemy> gameAllEnemies;
    private List<Hero> gameAllHeroes;
    
    public GameData() {
        
    }
    
    
    // METHODS
    
    public void addPlayer(Player player) { // Add Player
        gameAllPlayers.add(player);
    }

    // Add Map
    public void addMap(Map map) {
        gameAllMaps.add(map);
    }

    // Add Enemy
    public void addEnemy(Enemy enemy) {
        gameAllEnemies.add(enemy);
    }

    // Add Hero
    public void addHero(Hero hero) {
        
        gameAllHeroes.add(hero);
    }
    
}
