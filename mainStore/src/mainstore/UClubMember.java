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
public class UClubMember extends User
{
    private final double Rewards = 0.05;
    private final double AnnualFee = 19.95;
    private double RewardsAmount;
    private double Credit;
    
    public double getRewards() {
        return Rewards;
    }
    
    public double getAnnualFee() {
        return AnnualFee;
    }
    
    public double getRewardsAmount(){
        return RewardsAmount;
    }
    
    public void setRewardsAmount(){
        this.RewardsAmount = this.getRewards()*this.getCartTotal(); 
    }
    
    public double getCredit(){
        return Credit;
    }
    
    public void setCredit() {
        this.Credit = this.getRewardsAmount();
    }
    
    
}
