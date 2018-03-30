/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainstore;

/**
 *
 * @author Taylor Jones
 * @author Emily Rodriguez 
 */
public abstract class Category {
    
    public abstract void showAvailableItems();
    
    public abstract int buyItem(int itemNum, int total);
    
    public abstract boolean changeStock(int itemNum, int total, boolean remove);

    public abstract int cancelItem(int cancel);
}
