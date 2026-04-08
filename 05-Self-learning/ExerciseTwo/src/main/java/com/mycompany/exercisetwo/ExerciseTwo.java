/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercisetwo;

/**
 *
 * @author prashnamshrestha
 */
public class ExerciseTwo {

    public static void main(String[] args) {
       
        NotificationService instance1 = NotificationService.getInstance();
        NotificationService instance2 = NotificationService.getInstance();
        
        System.out.println(instance1 == instance2);
        instance1.sendNotification("Prashnam", "Hello");
        instance1.sendNotification("Prashnam", "Hello");
        System.out.println(instance2.getNotificationCount());
    }
    
}
