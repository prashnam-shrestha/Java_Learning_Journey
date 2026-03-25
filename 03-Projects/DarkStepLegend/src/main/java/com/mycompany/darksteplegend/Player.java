/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class Player implements Serializable{
    
    private String playerName;
    private String password;
    // PLAYER DATA
    private List<GameWorld> playerWorlds;
    private List<Hero> playerHeroes;
    private List<Map> playerMaps;
    
    private int playerGold;
    
    // CONSTRUCTOR
    public Player(String name, String pass, GameData data) {
        
        setPlayerName(name);
        setPlayerWorlds(new ArrayList<>());
        setPlayerHeroes(new ArrayList<>());
        setPlayerMaps(new ArrayList<>());
        setPlayerGold(100);
        setPassword(pass);
        
        Map map = new Map("JUNGLE", data);
        Hero mage = new Hero("Mage", 250, 0, 15, 20, 30);
        this.addPlayerHero(mage);
        this.addPlayerMap(map);
        
    }
    //  METHODS 
    public void addPlayerHero(Hero hero) { // Add new unlocked HERO
        getPlayerHeroes().add(hero);
    }
    
    public void addPlayerMap(Map newMap) { // Add new unlocked MAP
        getPlayerMaps().add(newMap);
    }
    
    public void addPlayerWorld(GameWorld newWorld) { // Add new WORLD
        getPlayerWorlds().add(newWorld);
    }
    
    public boolean depositGold(int amount) { // Deposit GOLD
        playerGold += amount;
        return true;
    }
    
    public boolean withdrawGold(int amount) { // Withdraw GOLD
        if (getPlayerGold() < amount) {
            return false;
        }
        playerGold -= amount;
        return true;
    }

    // GETTERS AND SETTERS  
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<GameWorld> getPlayerWorlds() {
        return playerWorlds;
    }

    public void setPlayerWorlds(List<GameWorld> playerWorlds) {
        this.playerWorlds = playerWorlds;
    }

    public List<Hero> getPlayerHeroes() {
        return playerHeroes;
    }

    public void setPlayerHeroes(List<Hero> playerHeros) {
        this.playerHeroes = playerHeros;
    }

    public List<Map> getPlayerMaps() {
        return playerMaps;
    }

    public void setPlayerMaps(List<Map> playerMaps) {
        this.playerMaps = playerMaps;
    }

    public int getPlayerGold() {
        return playerGold;
    }

    public void setPlayerGold(int playerGold) {
        this.playerGold = playerGold;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
