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
        bathroom bath = new bathroom();
        Scanner scan = new Scanner(System.in);
        bath.showAvailableItems();
        bath.buyItem(1004, 2);
        
    }
    
}
