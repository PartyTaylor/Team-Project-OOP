/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstock;

import java.util.Scanner;
/**
 *
 * @author Taylor Jones
 * @author Emily Rodriguez
 */
public class Login {
    
    public static void main(String[] args) {
        String Username;
        String Password;
        
        System.out.println("Login");
        Scanner User = new Scanner(System.in);
        System.out.println("Enter Username: ");
        Username = User.next();
        
        Scanner Pass = new Scanner(System.in);
        System.out.println("Enter Password: ");
        Password = Pass.next();
        
        if(Username.equals(Username) && Password.equals(Password)){
            
            System.out.println("Welcome!");
        }
        
        else if (Username.equals(Username)){
            System.out.println("Invalid Password");
        }
        else if (Password.equals(Password)){
            System.out.println("Invalid Username");
        } else {
            System.out.println("Invalid Username and Password!");
        }
    }
}
