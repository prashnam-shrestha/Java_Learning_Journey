/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darksteplegends;

import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class DarkstepLegends {

    public static void main(String[] args) {
        System.out.println("Welcome to DarkStep Legends!");
        
        Item healer = new Item("Healer potion", ItemType.HEALER, 30);
        Item poison = new Item("Poison", ItemType.POISON, 40);
        Item shield = new Item("Shield", ItemType.SHIELD, 0);
        
        Hero xavier = new Hero("Xavier", 250, 10, 100);
        Enemy goblin = new Enemy("Goblin", 100, 25, 100); 
        
        xavier.addItemInventory(healer);
        xavier.addItemInventory(poison);
        xavier.addItemInventory(shield);
        boolean attack = true;
        
        while (true) {
            if (attack) {
                goblin.passiveAttack(xavier);
            }
            
            
            System.out.println("HP: " + xavier.getHp());
            System.out.println("MANA: " + xavier.getMana());
            System.out.println("1. Passive Attack");
            System.out.println("2. Ultimate Attack");
            System.out.println("3. Use item");
            System.out.println("4. Run");
            System.out.printf("Enter choice:");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    xavier.passiveAttack(goblin);
                    break;
                case 2:
                    xavier.useUltimate(goblin);
                    break;
                case 3:
                    if (xavier.showInventory()) {
                        System.out.printf("Enter choice:");
                        int choice1 = sc.nextInt() - 1;
                        xavier.useItem(choice1, goblin);
                    }
                    break;
                case 4:
                    attack = false;
                    break;
                default:
                    return;
                    
            }
            
        }
               
    }
    
    public static Scanner sc = new Scanner(System.in);
}
