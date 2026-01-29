/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.notification;

/**
 *
 * @author prashnamshrestha
 */
public class Notification {

    public static void main(String[] args) {
        Notifier noti1 = new Notifier();
        noti1.send("HELLO");
        noti1.send("HELLO BABY", 933290322);
        noti1.send("HELLO SANU", "Instagram");
    }
}
