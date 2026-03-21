/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegends;

import static com.mycompany.darksteplegends.DarkstepLegends.createWorldDesert;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class Player {
    
    private String name;
    private int masterGold;
    private List<Hero> unlockedHeros;
    private List<World> unlockedWorlds;
    
    public Player(String name) {
        
        setName(name);
        setMasterGold(100);
        setUnlockedHeros(new ArrayList<>());
        setUnlockedWorlds(new ArrayList<>());
        
        // load default heros
        Hero mage = new Hero("Mage", 250, 35, 60); // ultimate = Poison Burst (damage)
        Hero warrior = new Hero("Warrior", 400, 30, 80); // ultimate = Rage (damage boost)
        
        unlockHero(mage);
        unlockHero(warrior);
        
        // Load default world
        World world = createWorldDesert();
        
        unlockWorld(world);
        
    }
    public void unlockHero(Hero hero) {
        unlockedHeros.add(hero);
    }
    
    public void unlockWorld(World world) {
        unlockedWorlds.add(world);
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<World> getUnlockedWorlds() {
        return unlockedWorlds;
    }

    public void setUnlockedWorlds(List<World> unlockedWorlds) {
        this.unlockedWorlds = unlockedWorlds;
    }
    
   
    
    public int getMasterGold() {
        return masterGold;
    }

    public void setMasterGold(int masterGold) {
        this.masterGold = masterGold;
    }

    public List<Hero> getUnlockedHeros() {
        return unlockedHeros;
    }

    public void setUnlockedHeros(List<Hero> unlockedHeros) {
        this.unlockedHeros = unlockedHeros;
    }
    
    
    
}
