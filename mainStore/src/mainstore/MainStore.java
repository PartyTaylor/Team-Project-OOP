/*
 */
package mainstore;

import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Taylor Jones
 * @author Emily Rodriguez 
 */
public class MainStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        BedBath bath = new BedBath();
        Scanner scan = new Scanner(System.in);
        bath.showAvailableItems();
        bath.buyItem(1004, 1);
        bath.cancelItem(1004, 1);
        
        Decor dec = new Decor();
        dec.showAvailableItems();
        dec.buyItem(2004, 1);
        dec.cancelItem(2004, 1);
        
        Furniture fur = new Furniture();
        fur.showAvailableItems();
        fur.buyItem(3004, 1);
        fur.cancelItem(3004, 1);
        
        Home home = new Home();
        home.showAvailableItems();
        home.buyItem(4004, 1);
        home.cancelItem(4004, 1);
                
        Kitchen kitchen = new Kitchen();
        kitchen.showAvailableItems();
        kitchen.buyItem(5004, 1);
        kitchen.cancelItem(5004, 1);
        
        Outdoor outdoor = new Outdoor();
        outdoor.showAvailableItems();
        outdoor.buyItem(6004, 1);
        outdoor.cancelItem(6004, 1);
        
        Rugs rugs = new Rugs();
        rugs.showAvailableItems();
        rugs.buyItem(7004, 1);
        rugs.cancelItem(7004, 1);
        
    }
    
}
