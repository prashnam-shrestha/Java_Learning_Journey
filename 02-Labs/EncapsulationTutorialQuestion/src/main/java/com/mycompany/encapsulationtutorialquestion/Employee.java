/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.encapsulationtutorialquestion;

/**
 *
 * @author prashnamshrestha
 */
public class Employee {
    
    private String employeeId;
    private String employeeName;
    private double salary;
    
    public Employee(String id, String name, double salary) {
        
        setEmployeeId(id);
        setEmployeeName(name);
        setSalary(salary);
             
    }
    
    public String displayEmployeeDetails() {
        return String.format("Employee ID: %s \nEMployee Name: %s \nSalary: %s\n", getEmployeeId(), getEmployeeName(), getSalary());
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
             this.salary = salary;
             
        }
    }
           

}
