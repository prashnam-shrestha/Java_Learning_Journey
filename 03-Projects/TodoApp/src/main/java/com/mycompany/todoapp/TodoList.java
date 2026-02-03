package com.mycompany.todoapp;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author prashnamshrestha
 */
public class TodoList {
    ArrayList<Tasks> List = new ArrayList<Tasks>();
    
    private static int totalTasks = 0;
    
    public TodoList() {
        
    }
    
    public void addTask(String description) {
        totalTasks++; 
        Tasks t1 = new Tasks(description);
        List.add(t1);

    }
    
    public void viewTask() {
        
        System.out.println("-- -Your tasks: ---");
        for (Tasks t: List) {
            System.out.printf("%s | Completed: %s | %s |\n",List.indexOf(t) + 1, t.isCompleted(), t.getDescription());
        }
        System.out.printf("Total tasks : %s\n", getTotalTasks());
    }
    
    public void deleteTask(int number) {
        
        int indexTarget = number - 1;
        
        if ((indexTarget >= 0) && (indexTarget < List.size())) {
            
            List.remove(indexTarget);
            System.out.printf("Task number %s Deleted!\n", number);
            setTotalTasks(getTotalTasks() - 1);
            
        }
        else {
            System.out.printf("Task number %s not found!\n", number);
        }
    }
    
    public void changeStatus(int number) {
        
        int indexTarget = number - 1;
        
        if ((indexTarget >= 0) && (indexTarget < List.size()))
        {
            boolean currentStatus = List.get(indexTarget).isCompleted();
            List.get(indexTarget).setCompleted(!currentStatus);
                        
            System.out.printf("Task number %s status changed!\n", number);
        }
        else {
            System.out.printf("Task number %s not found!\n", number);
        }
        
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        TodoList.totalTasks = totalTasks;
    }
    
    
}
