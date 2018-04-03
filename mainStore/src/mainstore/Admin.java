/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author PartyTaylor
 */
public class Admin {
    String[] names = new String[15]; 
    int count = 0;
    boolean check = false;
    //will print purchase history
     public void showPurchaseHistory(String userHist)throws FileNotFoundException{
        for(int i = 0; i < count; i++){
            if(userHist.equals(names[i])){
                check = true;
            }
        }
        if(check = false){
            System.out.println("Not a username!");
            return;
        }
        File input = new File(userHist + "history.txt");
        try (Scanner sc = new Scanner(input)) {
            System.out.println("Now printing " + userHist + " Purchase History!");
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
     }
     
     
     //will print all users for the admin to chose from 
     public void showAllUsers()throws FileNotFoundException{
        File input = new File("Users.txt");
        String keep = "";
        try (Scanner sc = new Scanner(input)) {
            System.out.println("All Users With History!");
            while(sc.hasNext()){
                count++;
                keep = sc.next();
                names[count] = keep;
                System.out.println(keep);
                sc.next();
                sc.next();
                sc.next();
            }
        }
     }
}
