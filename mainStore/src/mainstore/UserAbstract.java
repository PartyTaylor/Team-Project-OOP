/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    int rewardAmount;
    
    public UserAbstract() throws FileNotFoundException{
        userName = "";
        password = "";
        uclub = false;
        rewardAmount = 0;
    }
    
    public void isUserPass(String userName, String password){
        File input = new File("Users.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserAbstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        W+
    }
     
    public void newAccount(String userName, String password){
        
    }
    
    public boolean isUClub(){
        
    }
    
   
    
}
