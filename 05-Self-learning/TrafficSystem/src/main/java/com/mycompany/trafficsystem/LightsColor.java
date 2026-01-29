/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trafficsystem;

/**
 *
 * @author prashnamshrestha
 */
public class LightsColor {
    
    Lights light;
    
    public LightsColor(Lights light) {
        this.light = light;
    }
    
    public enum Lights {
        RED,
        YELLOW,
        GREEN;
    }
    
    public void check() {
        if (light == Lights.RED) {
            System.out.println("STOP");
        }
        else if (light == Lights.GREEN) {
            System.out.println("GO");
        }
        else {
            System.out.println("WAIT");
        }
    }
}
