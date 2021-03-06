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

/**
 *
 * @author Taylor Jones
 * @author Emily Rodriguez 
 */
public class Kitchen extends Category{
    //initalize the needed varibales
    PrintWriter pw;
    String [] itemDescriptions = new String[5];
    double [] itemPrices = new double[5];
    
    //sets the descriptions for the names
    public Kitchen() throws FileNotFoundException {
        itemDescriptions[0] = "Porch & Den third Ward Jefferson Espresso Sliding Door Stackable Cabinet            ";
        itemDescriptions[1] = "Gracewook Hollow Alleyn Black Distressed Oak Finish Kitchen Island and Barstools set";
        itemDescriptions[2] = "Anolon Advanced Bronze Collection Nonstick 11-piece Cookware Set                    ";
        itemDescriptions[3] = "SPT Energy Star 18-inch Built-in Dishwasher- Stainless Steel                        ";
        itemDescriptions[4] = "GE Profile Series Energy Star Counter-depth French-door Refrigerator with Keurig    ";
        
        itemPrices[0] = 99.49;
        itemPrices[1] = 824.99;
        itemPrices[2] = 302.99;
        itemPrices[3] = 442.49;
        itemPrices[4] = 3485.99;
    }
    
    //gets the item price
    @Override
    public double getItemPrice(int trueNum){
        return itemPrices[trueNum];
    }
    
    //This function will make sure that the item is available to buy and will call to change the stock
    @Override
    public int buyItem(int itemNum, int total)throws FileNotFoundException{
        if(changeStock(itemNum, total, true))
        {
            System.out.println("Added to Cart!");
            return 1;
        }
        else
        {
            System.out.println("That item number is false or the stock is UNAVAILABLE, please try again!");
            return -1;
        }
    }
    
    // gets the item description
    @Override
    public String getItemDescription(int trueNum){
        return itemDescriptions[trueNum];
    }
    
    //this will print out the list of available items in this category
    @Override
    public void showAvailableItems()throws FileNotFoundException{
        File inputT = new File("Kitchen.txt");
        try (Scanner sc = new Scanner(inputT)) {
            System.out.println("Item Number\tDescription\t\t\t\t\\t\t\t\t\t\tPrice\t\tQuantity In Stock");
            for(int i = 0; i <= 4; i++){
                System.out.print(sc.nextInt() + "\t\t" + itemDescriptions[i] + "\t\t" + itemPrices[i] + "\t\t");
                int test = sc.nextInt();
                if(test == 0)
                    System.out.println("UNAVAILABLE");
                else
                    System.out.println(test);
            }
        }
        
    }
    
    //This is called to change the stock of any item, it requires the item numbe
    // the total they wish to buy or put back and a boolean to see if they are removing or adding
    @Override
    public boolean changeStock(int itemNum, int total, boolean remove)throws FileNotFoundException{
        File inputT = new File("Kitchen.txt");
        File temp = new File("tempKit.txt");
        int test;
        boolean ret = false;
        try (Scanner sc = new Scanner(inputT)) {
            pw = new PrintWriter(temp);
            while (sc.hasNextInt()) {
                int i = sc.nextInt();
                pw.print(i);
                //looks for the itemNum
                if(i == itemNum)
                {
                    //this will let the other functions know if there is really a item with that num
                    ret = true;
                    pw.print("\r\n");
                    //checks to see if it is adding stock or removing stock
                    if(remove == true)
                    {
                        test = sc.nextInt();
                        //this keeps our new stock file correct while also letting buy know if there is not enough stock
                        if((test - total) >= 0)
                            pw.print(test - total);
                        else
                        {
                            pw.print(test);
                            ret = false;
                        }
                    }
                    else
                        pw.print(sc.nextInt() + total);
                    pw.print("\r\n");
                }
                else
                {
                    pw.print("\r\n");
                    pw.print(sc.nextInt());
                    pw.print("\r\n");
                }
            }
            //close the canner and writer
        }
        pw.close();
        //This will delete the old stock file and replace it with the new one
        inputT.delete();
        temp.renameTo(inputT);
        //returns true if all went well
        return ret;
    }
    
    //This will cancel an item from the shop and will place the stock back
    @Override
    public int cancelItem(int itemNum, int total)throws FileNotFoundException{
        if(changeStock(itemNum, total, false))
            System.out.println("Return Worked!");
        else
            System.out.println("The Item Number is wrong! Try again!");
        return 1;
    }
    
}