/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class Map {
    
    private PhaseType currentPhase = PhaseType.SURVIVAL;
    private String mapName;
    private GameData data;
    HashMap<PhaseType, List<Enemy>> mapAllEnemies = new HashMap<>();
    
    public Map(String name, GameData data) {
        
        setData(data);
        
        // Fill up with enemies;
        List<Enemy> phase1 = new ArrayList<>();
        List<Enemy> phase2 = new ArrayList<>();
        List<Enemy> phase3 = new ArrayList<>();
        List<Enemy> phase4 = new ArrayList<>();
        
        addEnemyMap(phase1, EnemyType.EASY, 3);
        addEnemyMap(phase2, EnemyType.MEDIUM, 3);
        addEnemyMap(phase3, EnemyType.HARD, 3);
        addEnemyMap(phase4, EnemyType.BOSS, 1);
        
        mapAllEnemies.put(PhaseType.SURVIVAL, phase1);
        mapAllEnemies.put(PhaseType.BLOODBATH, phase2);
        mapAllEnemies.put(PhaseType.SLAUGHTER, phase3);
        mapAllEnemies.put(PhaseType.EXTINCTION, phase4);
        
        
    }
    // METHODS
    
    // Gets enemy from phase
    public Enemy getEnemyFromPhase() {

        for (Enemy e: mapAllEnemies.get(currentPhase)) {

   
            if (e.isIsAlive()) {
                return e;
            }
        }
        return null;
    }
    
    // Checks map progression and increases phases
    public boolean checkMapProgression() {
        
        // LOOP THROUGH CURRENT PHASE
        for (Enemy e: mapAllEnemies.get(currentPhase)) {
            
            // If even one enemy is alive
            if (e.isIsAlive()) {
                
                return false; // Do ntg and return map incomplete
            }
        }
        // IF all are dead in specific phase
        switch (currentPhase) {
            
            case (PhaseType.SURVIVAL):
                currentPhase = PhaseType.BLOODBATH;
                break;
                
            case (PhaseType.BLOODBATH):
                currentPhase = PhaseType.SLAUGHTER;
                break;
                
            case (PhaseType.SLAUGHTER):
                currentPhase = PhaseType.EXTINCTION;
                break;
             
            case (PhaseType.EXTINCTION):
                return true; // Return map complete
            
            default:
                break;               
        }
        return false; // Return map incomplete
    }
    
    public void resetAllEnemies() { // Reset all ENEMIES
        for (PhaseType type : mapAllEnemies.keySet()) {

            for (Enemy e : mapAllEnemies.get(type)) {
                e.resetStatus();
            }
        }
        currentPhase = PhaseType.SURVIVAL;
    }
    
    private void addEnemyMap(List<Enemy> phaseList, EnemyType type, int count) { // Add enemy in the map
        
        for (int i = 0; i < count; i++) {
            phaseList.add(data.getEnemyFromData(type));
        }
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public GameData getData() {
        return data;
    }

    public void setData(GameData data) {
        this.data = data;
    }

    public HashMap<PhaseType, List<Enemy>> getMapAllEnemies() {
        return mapAllEnemies;
    }

    public void setMapAllEnemies(HashMap<PhaseType, List<Enemy>> mapAllEnemies) {
        this.mapAllEnemies = mapAllEnemies;
    }
    
    
}
