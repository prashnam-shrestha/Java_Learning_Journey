/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.darksteplegend;

import java.io.Serializable;

/**
 *
 * @author prashnamshrestha
 */
public class Item implements Serializable{
    
    private String itemName;
    private ItemType itemType;
    private int itemEffect;
    
    public Item(String name, ItemType type, int effect) {
        
        setItemName(name);
        setItemType(type);
        setItemEffect(effect);
    }
    // METHODS
    public String getItemInfo() {
        return String.format("NAME: %s | TYPE: %s | EFFECT: %s\n", itemName, itemType, itemEffect);
    }
    

    // GETTERS AND SETTERS
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getItemEffect() {
        return itemEffect;
    }

    public void setItemEffect(int itemEffect) {
        this.itemEffect = itemEffect;
    }
    
    
}
