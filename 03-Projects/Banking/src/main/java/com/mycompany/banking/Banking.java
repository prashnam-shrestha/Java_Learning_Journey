/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banking;

import java.util.ArrayList;

/**
 *
 * @author prashnamshrestha
 */
public class Banking {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("Alice", 1000)); // index 0
        accounts.add(new Account("Bob", 500));  // index 1
        accounts.add(new Account("Poor Charlie", 100));  // index 2
        
        accounts.get(0).deposit(200);
        accounts.get(1).withdraw(600);
        accounts.get(0).transferBalance(accounts.get(2), 500);
        
        
        for (Account a: accounts) {
            System.out.println(a.getAccountInfo());
        }
        
        System.out.printf("CEO Report: There are %s accounts holding "
                + "a total of Rs %s ", Account.getCustomerCount(), Account.getBankAssets());
       
        
    }
}
