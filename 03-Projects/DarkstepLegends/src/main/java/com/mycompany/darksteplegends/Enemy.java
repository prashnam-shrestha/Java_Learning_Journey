/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegends;

/**
 *
 * @author prashnamshrestha
 */
public class Enemy extends Character{
    
    public Enemy(String name, int hp, int passiveDmg, int ultimateEffect) {
        
        super(name, hp, passiveDmg, ultimateEffect);
    }
    
    // Methods
    
    // User Ultimate
    public void useUltimate(Character target) {
        
        
    }
    
    // Reward winner after death
    public void rewardWinner(Character from) {
        
        from.getInventory().clear();
        
        
    }
    
}
