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
public abstract class User 
{

    private String FirstName;
    private String LastName;
    private String MiddleIntial;
    private String EmailAddress;
    private String Password;
    private String Username;
    private boolean AllowAdmin; ??? 
    /**
     * @param args the command line arguments
     */
    public User(String Username, String Password, String FirstName, String LastName, String MiddleInitial)
     {
            setUsername(Username);
            setPassword(Password);
            setFirstName(FirstName);
            setLastName(LastName);
            setMiddleIntial(MiddleInital);
     }
     
     public final void setUsername(String Username)
     {
         this.Username = Username;
     }
     public final void setPassword(String Password)
    {
        this.Password = Password;
    }
    public final void setAllowAdmin(Boolean AllowAdmin)
    {
        this.AllowAdmin = AllowAdmin;
    }
    public final void setFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }
    public final void setLastName(String LastName)
    {
        this.LastName = LastName;
    }
    public final void setMiddleInitial(String MiddleInitial)
    {
        this.MiddleIntital = MiddleInitial
    }
    
    public final String getUsername()
    {
        return this.Username;
    }
    
    public final String getPasword()
    {
        return this.Password;
    }
    
    public final String getFirstName()
    {
        return this.FirstName;
    }
    
    public final String getLastName()
    {
        return this.LastName;
    }
    
    public final String getMiddleInitial()
    {
        return this.MiddleIntial;
    }
    
    public final String getPassword()
    {
        return this.Password;
    }
    public final String getFirstName()
    {
        return this.FirstName;
    }
    public final String getLastName()
    {
        return this.LastName;
    }
    public final String 
    
     public void 
