/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Taylor Jones
 */
public class Cart {
    int[] amount = new int[50];
    int[] itemNumList = new int[50];
    String[] itemDesc = new String[50];
    double[] priceList = new double[50];
    Category[] catList = new Category[50];
    int count = 0;
    PrintWriter pw;
    
    //adds an item to the cart storing all information needed
    public void addCart(Category random, int itemNum, int countIn) throws FileNotFoundException{
        int trueNum = itemNum % 1000;
        if(random.buyItem(itemNum, countIn) == 1){
            itemNumList[count] = itemNum;
            catList[count] = random;
            amount[count] = countIn;
            itemDesc[count] = random.getItemDescription(trueNum);
            priceList[count] = random.getItemPrice(trueNum) * countIn;
            count++;
        }
                
    }
    
    //prints the cart for the user ot double check all their items
    public double printCart(boolean isClub){
        NumberFormat formatter = new DecimalFormat("#0.00");  
        System.out.println("--------------------------------------------------");
        System.out.println("Items: ");
        for(int i = 0; i < count; i++){
            System.out.println(amount[i] + "x" + itemDesc[i] + " " + priceList[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Subtotal:      $" + formatter.format(total()));
        System.out.println("Tax(8.35):      $" + formatter.format(total() * .0825));
        System.out.println("TOTAL:      $" + formatter.format(total() + (total() * .0825)));
        
        if(isClub){
            System.out.println("UClub Rewards:      $" + (total() * .05));
            System.out.println("--------------------------------------------------");
            return (total() * .05);
        }
        System.out.println("--------------------------------------------------");
        return 0;
        
        
    }
    
    //if the user closes without a purchase it will return the stock for all items in the cart
    public void cancelCart() throws FileNotFoundException{
        for(int i = 0; i < count; i++){
            catList[i].cancelItem(itemNumList[i], amount[i]);
        }
        catList = null;
        itemNumList = null;
        amount = null;
        itemDesc = null;
        priceList = null;
        count = 0;
    }
    
    //calcs the total price of the cart
    public double total(){
        double total = 0;
        for(int i = 0; i < count; i++){
            total += priceList[i];
        }
        return total;
    }
    
    //updates the users purchase history after a cart has been completed
    public void updateHist(String userName) throws FileNotFoundException{
        File input = new File(userName + "history.txt");
        File temp = new File("tempUser.txt");
        try (Scanner sc = new Scanner(input)) {
            String test;
            pw = new PrintWriter(temp);
            while(sc.hasNext()){
                pw.print(sc.nextLine());
                pw.print("\r\n");
            }
            for(int i = 0; i < count; i++){
                pw.print(amount[i] + " " + itemDesc[i] + " " + priceList[i]);
                pw.print("\r\n");
            }
        }
        pw.close();
        input.delete();
        temp.renameTo(input);
    }
    
}
