/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashnamshrestha
 */
public class Data {
    private List<User> users;
    private List<Admin> admins;
    private List<Student> students;
    private List<Subject> subjects;
    
    public Data() {
        
        setUsers(new ArrayList<>());
        setAdmins(new ArrayList<>());
        setStudents(new ArrayList<>());
        setSubjects(new ArrayList<>());
    }
    // METHODS
    public void addStudent(Student student) {
        students.add(student);
    }

    // GETTERS AND SETTERS

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    
    
    
}
