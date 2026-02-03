/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todoapp;

import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class TodoApp {

    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        TodoList Today = new TodoList();
        
        while (true) {
            System.out.println("--- Todo List app ---");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Change status-");
            System.out.println("4. View task");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                System.out.print("Write description: ");
                scanner.nextLine();
                String description = scanner.nextLine();
                Today.addTask(description);
            }
            
            else if (choice == 2) {
                Today.viewTask();
                System.out.print("Enter task number to delete: ");
                int number = scanner.nextInt();
                Today.deleteTask(number);
            }
            
            else if (choice == 3) {
                Today.viewTask();
                System.out.print("Enter task number to change: ");
                int number = scanner.nextInt();
                Today.changeStatus(number);
            }
            
            else if (choice == 4) {
                Today.viewTask();
            }
            
            else if (choice == 5) {
                System.out.println("Enjoy your day!");
                break;
            }
            else {
                System.out.println("Choice not found!\nPlease enter between 1 - 4");
            }
            System.out.println();
        }
       
    }
}
