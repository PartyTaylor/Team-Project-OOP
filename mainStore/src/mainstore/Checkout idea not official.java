/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstock;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arnol
 */
public class Checkout {
    
private final double TAX = .0825;
private double CartTotal;
    
    List<String> items;
    double Total;
    
    public Checkout(){
        items = new ArrayList<>();
    }
    
    public void addItems(String item){
        items.add(item);
    }
   
    public void getNumberOfItems(){
        System.out.println(items.size());
    }
    
    public String getItemNumber(int index){
        return items.get(index);
    }
       
    public void setCartTotal(double CartTotal){
    
        this.CartTotal = CartTotal;
    }
    public double getCartTotal(){
        
        return CartTotal;
    }  
}
