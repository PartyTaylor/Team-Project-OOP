/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstore;

import java.io.FileNotFoundException;

/**
 *
 * @author Taylor Jones
 * @author Emily Rodriguez 
 */
public abstract class Category {
    
    //these abstract classes will serve as the basis for each category making it easier to code in the menu
    public abstract void showAvailableItems()throws FileNotFoundException;
    
    public abstract int buyItem(int itemNum, int total)throws FileNotFoundException;
    
    public abstract boolean changeStock(int itemNum, int total, boolean remove)throws FileNotFoundException;

    public abstract int cancelItem(int itemNum, int total)throws FileNotFoundException;
    
    public abstract String getItemDescription(int trueNum);
    
    public abstract double getItemPrice(int trueNum);
}
