/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstock;

import java.util.Scanner;
/**
 *
 * @author arnol
 */
public class Login {
    
    public static void main(String[] args) {
        String Username;
        String Password;
        
        Password = " ";
        Username = " ";
        
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter Username: ");
        Username = input1.next();
        
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter Password: ");
        Password = input2.next();
        
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
