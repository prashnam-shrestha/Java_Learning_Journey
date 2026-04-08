/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercisetwo;

/**
 *
 * @author prashnamshrestha
 */
public class NotificationService {
    
    private static NotificationService instance;
    private int notificationCount;
    
    private NotificationService() {
        setNotificationCount(0);
    }
    
    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }
    
    public void sendNotification(String recipient, String message) {
        System.out.printf("[NOTIFICATION] To: %s | Message: %s\n", recipient, message);
        notificationCount++;
    }

    public int getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(int notificationCount) {
        this.notificationCount = notificationCount;
    }
    
    
    
}
