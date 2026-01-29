/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification;

/**
 *
 * @author prashnamshrestha
 */
public class Notifier {
    
    // OVERLOADING
    public void send(String message) {
        System.out.println("Emailing: " + message);
    }
    
    public void send(String message, long phoneNumber) {
        System.out.println("SMS to " + phoneNumber + " : " + message);
    }
    
    public void send(String message, String platform) {
        System.out.println("Sentding to " + platform + " : " + message);
    }
            
}
