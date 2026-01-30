/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universitysystem;

/**
 *
 * @author prashnamshrestha
 */
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    
    public void infoGeneral() {
        System.out.printf("Hi I'm %s, and I am %s years old.\n",name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    
    
}
