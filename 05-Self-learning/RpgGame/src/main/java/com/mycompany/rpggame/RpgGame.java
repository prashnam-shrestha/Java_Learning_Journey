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
        ArrayList<GameCharacter> party = new ArrayList<GameCharacter>();
        party.add(new GameCharacter("Thor", 100));
        party.add(new Mage("Gandalf", 80, 50));
        
        for (GameCharacter c: party) {
            c.attack();
        }
    }
}
