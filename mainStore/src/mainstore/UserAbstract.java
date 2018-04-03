/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Taylor Jones
 * @autrho Emily Rodriguez
 */
public class UserAbstract {
    
    PrintWriter pw;
    String userName;
    String password;
    boolean uclub;
    double rewardAmount;
    
    public UserAbstract() throws FileNotFoundException{
        userName = "";
        password = "";
        uclub = false;
        rewardAmount = 0.0;
    }
    
    public boolean isUserPass(String userTest, String passTest) throws FileNotFoundException{
        File input = new File("Users.txt");
        try (Scanner sc = new Scanner(input)) {
            String test;
            
            while(sc.hasNext()){
                if(sc.next().equals(userTest)){
                    if(sc.next().equals(passTest)){
                        System.out.println("The Login was complete!");
                        userName = userTest;
                        password = passTest;
                        uclub = Boolean.parseBoolean(sc.next());
                        rewardAmount = Double.parseDouble(sc.next());
                        sc.close();
                        return true;
                    }
                    else{
                        System.out.println("Wrong Password!");
                        sc.close();
                        return false;
                    }
                }
                else{
                    sc.next();
                    sc.next();
                    sc.next();
                }
            }
            System.out.println("Login Failed!");
            return false;
        }
   }
     
    public boolean newAccount(String userNew, String passNew) throws FileNotFoundException, IOException{
        File input = new File("Users.txt");
        File temp = new File("tempUser.txt");
        String test = "";
        boolean taken = false;
        try (Scanner sc = new Scanner(input)) {
            pw = new PrintWriter(temp);
            
            while(sc.hasNext()){
                test = sc.next();
                if(userNew.equals(test))
                    taken = true;
                pw.print(test);
                pw.print("\r\n");
            }
            if(taken){
                System.out.println("UserName is taken!");
                pw.close();
                input.delete();
                temp.renameTo(input);
                return false;
            }
            pw.print(userNew);
            pw.print("\r\n");
            pw.print(passNew);
            pw.print("\r\n");
            pw.print("false");
            pw.print("\r\n");
            pw.print("0");
            pw.print("\r\n");
            userName = userNew;
            password = passNew;
            uclub = false;
            rewardAmount = 0;
            File file = new File(userName + "history.txt");
            file.createNewFile();
        }
        pw.close();
        input.delete();
        temp.renameTo(input);
        return true;
    }
    
    public boolean isUClub(){
        return uclub;
    }
    
    public void upgrade() throws FileNotFoundException{
        uclub = true;
        System.out.println("Welcome to UClub!");
    }
    
    public double points(){
        return rewardAmount;
    }
    
    public void updatePoints(double points){
        rewardAmount += points;
    }
    
    public void updatePassword(String passNew){
        password = passNew;
        System.out.println("Password updated!");
    }
    
    public void closeUser() throws FileNotFoundException{
        File input = new File("Users.txt");
        File temp = new File("tempUser.txt");
        try (Scanner sc = new Scanner(input)) {
            String test;
            pw = new PrintWriter(temp);
            while(sc.hasNext()){
                test = sc.next();
                pw.print(test);
                pw.print("\r\n");
                if(test.equals(userName)){
                   sc.next();
                   pw.print(password);
                   pw.print("\r\n");
                   sc.next();
                   pw.print(uclub);
                   pw.print("\r\n");
                   sc.next();
                   pw.print(rewardAmount);
                   pw.print("\r\n");
                   
                }
                else{
                    pw.print(sc.next());
                    pw.print("\r\n");
                    pw.print(sc.next());
                    pw.print("\r\n");
                    pw.print(sc.next());
                    pw.print("\r\n");
                }
            }
        }
        uclub = true;
        pw.close();
        input.delete();
        temp.renameTo(input);
    }
    
    /*public void updateHistory(String desc) throws FileNotFoundException{
        File input = new File(userName + "history.txt");
        File temp = new File("tempUser.txt");
        try (Scanner sc = new Scanner(input)) {
            String test;
            pw = new PrintWriter(temp);
            while(sc.hasNext()){
                pw.print(sc.next() + " " + sc.next());
                pw.print("\r\n");
            }
            pw.print(itemNum);
            pw.print(" " + desc);
            pw.print("\r\n");
        }
        pw.close();
        input.delete();
        temp.renameTo(input);
    }*/
}

