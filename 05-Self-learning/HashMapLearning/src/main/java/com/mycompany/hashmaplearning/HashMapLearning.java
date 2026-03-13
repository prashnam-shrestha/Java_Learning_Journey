/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hashmaplearning;

import java.util.HashMap;

/**
 *
 * @author prashnamshrestha
 */
public class HashMapLearning {

    public static void main(String[] args) {
      
        HashMap fun = new HashMap();
        fun.put("name", "Password");
        fun.put("name2", "Password2");
        
        fun.replace("name", "NewP@ssword");
        System.out.println(fun.keySet());
    } 
    
}
