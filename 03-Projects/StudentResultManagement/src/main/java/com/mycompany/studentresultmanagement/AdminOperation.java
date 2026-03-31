/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.InputHelper.*;
import static com.mycompany.studentresultmanagement.MenuPrinter.*;

/**
 *
 * @author prashnamshrestha
 */
public class AdminOperation {
    
    public static void addStudentOperation(Data data) {
        
        String name = getValidString("Enter name: ");
        String password = getValidString("Create password: ");

        while (true) {
            try {
                String id = getValidString("Create ID: ");

                boolean stdExists = data.getStudents().stream()
                        .anyMatch(s -> s.getStudentId().equals(id));
                
                if (stdExists) {
                    throw new InputStudentIdExists("- Student ID already exists!");
                }
                        
                Student studentNew = new Student(name, password, id);
                data.addStudent(studentNew);
                return;
                
            }
            catch (InputStudentIdExists e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
