/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problemsolvinggemini2;

/**
 *
 * @author prashnamshrestha
 */
public class Password {
    private String password;
    
    public Password(String password){
        setPassword(password);
    }
    
    public boolean isValid(String password) {
        int length = password.length();
        boolean oneUpperCase = false;
        boolean oneNumber = false;
        
        if (length < 8) {
            return false;
        }
        
        for (int i = 0; i < length; i++) {
            char letter = password.charAt(i);
            if (Character.isUpperCase(letter)) {
                oneUpperCase = true;
            }
            else if (Character.isDigit(letter)) {
                oneNumber = true;
            }
        }
        
        if (oneUpperCase && oneNumber) {
            return true;
        }
        return false;
        
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
