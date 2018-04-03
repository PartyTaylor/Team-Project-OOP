/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstock;

/**
 *
 * @author Taylor Jones
 * @author Emily Rodriguez
 */
public class  NonMemberUser extends User
{
    private boolean upgrade = false;
    
    public void setUpgrade(boolean x)
    {
        this.upgrade = x;
    }
    
    public void Upgrade(char choice)
    {
        if(choice =='1')
        {
            this.setUpgrade(true);
        }
    }
}
