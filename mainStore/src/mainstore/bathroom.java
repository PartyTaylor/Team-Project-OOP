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
 * @author Emily Rodriguez
 */
public class bathroom extends Category {

 
    PrintWriter pw;
    Scanner scan;
    
    String itemDescription;
    int price;
    int itemNumber;
    
    String [] itemDescriptions = new String[5];
    double [] itemPrices = new double[5];

    public bathroom() throws FileNotFoundException {
        itemDescriptions[0] = "Harper Blvd Laird Granite Top Bath Vanity Sink";
        itemDescriptions[1] = "Classique Espresso Double-door Floor Cabinet";
        itemDescriptions[2] = "OVE Decors Rachel 70-inch Freestanding Bathtub";
        itemDescriptions[3] = "Mohawk Home Spa Bath Rug                    ";
        itemDescriptions[4] = "Dark Espresso 2-door Linen Tower by Mohawk";
        
        itemPrices[0] = 420.74;
        itemPrices[1] = 116.99;
        itemPrices[2] = 1049.98;
        itemPrices[3] = 48.14;
        itemPrices[4] = 123.74;
        
        scan = new Scanner(System.in);
    }
    
    @Override
    public int buyItem(int itemNum, int total){
        if(changeStock(itemNum, total, true))
            return 1;
        else
        {
            System.out.println("That many is UNAVAILABLE!");
            return -1;
        }
    }
    
    @Override
    public void showAvailableItems(){
        File inputT = new File("BathroomTest.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(inputT);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(bathroom.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Item Number\tDescription\t\t\t\t\t\tPrice\t\tQuantity In Stock");
        for(int i = 0; i <= 4; i++){
            System.out.print(sc.nextInt() + "\t\t" + itemDescriptions[i] + "\t\t" + itemPrices[i] + "\t\t");
            int test = sc.nextInt();
            if(test == 0)
                System.out.println("UNAVAILABLE");
            else
                System.out.println(test);
        }
        sc.close();
        
    }
    
    @Override
    public boolean changeStock(int itemNum, int total, boolean remove){
        File inputT = new File("BathroomTest.txt");
        File temp = new File("temp.txt");
        int test;
        boolean ret = true;
        Scanner sc = null;
        try {
            pw = new PrintWriter(temp);
            sc = new Scanner(inputT);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(bathroom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(sc.hasNextInt())
        {
            
            int i = sc.nextInt();
            pw.print(i);
            if(i == itemNum)
            {
                pw.print("\r\n");
                if(remove == true)
                {
                    test = sc.nextInt();
                    if((test - total) >= 0)
                        pw.print(test - total);
                    else
                    {
                        pw.print(0);
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
        sc.close();
        pw.close();
        inputT.delete();
        temp.renameTo(inputT);
        return ret;
    }
    
    @Override
    public int cancelItem(int cancel){
        return 1;
    }
    
}
