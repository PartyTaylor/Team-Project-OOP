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
public class Furniture extends Category{
     //initalize the needed varibales
    PrintWriter pw;
    String [] itemDescriptions = new String[5];
    double [] itemPrices = new double[5];
    
    //sets the descriptions for the names
    public Furniture() throws FileNotFoundException {
        itemDescriptions[0] = "Safavieh Bandelier Light Oak Arm Chair                                               ";
        itemDescriptions[1] = "Carson Carrington Brandbu Mid-Century Fold Down Futon                                ";
        itemDescriptions[2] = "Perth 5-Shelf Industrial Bookcase by Christopher Knight Home                         ";
        itemDescriptions[3] = "Copper Grove Carson Contemporary 70-inch Dar Brown Wood TV Cabinet with 2 Glass Doors";
        itemDescriptions[4] = "Carbon Loft Venter Country Farmhouse Natural Tone Plank Style Dining Table           ";
        
        itemPrices[0] = 242.67;
        itemPrices[1] = 323.99;
        itemPrices[2] = 177.98;
        itemPrices[3] = 186.57;
        itemPrices[4] = 814.49;
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
    
    //gets the item description
    @Override
    public String getItemDescription(int trueNum){
        return itemDescriptions[trueNum];
    }
    
    //gets the item price
    @Override
    public double getItemPrice(int trueNum){
        return itemPrices[trueNum];
    }
    
    //this will print out the list of available items in this category
    @Override
    public void showAvailableItems()throws FileNotFoundException{
        File inputT = new File("Furniture.txt");
        try (Scanner sc = new Scanner(inputT)) {
            System.out.println("Item Number\tDescription\t\t\t\t\t\t\t\t\t\t\tPrice\t\tQuantity In Stock");
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
        File inputT = new File("Furniture.txt");
        File temp = new File("tempFur.txt");
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