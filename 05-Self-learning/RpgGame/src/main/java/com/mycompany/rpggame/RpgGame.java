/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rpggame;

import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class RpgGame {

    public static void main(String[] args) {
        
        Warrior Thor = new Warrior("Thor", 100, 50);
        Mage Xavior = new Mage("Gandalf", 80, 50);
        
        
        Thor.attack(Xavior);
        Xavior.attack(Thor);
        
    }
}
