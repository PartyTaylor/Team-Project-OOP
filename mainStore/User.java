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

    private String MiddleInitial;

    private String EmailAddress;

    private String Password;

    private String Username;

    private boolean AllowAdmin; 

    private int UserID;

    private int Membership;

    /**

     *      
     * @param Username
     */
     

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

        this.MiddleInitial = MiddleInitial;

    }

    

    public final void setUserID(int UserID)

    {

        this.UserID = UserID;

    }

    

    public final void setMembership(int Membership)

    {

        this.Membership = Membership;

    }
    
    public final void setEmailAddress(String EmailAddress)
    {
        this.EmailAddress = EmailAddress;
    }

    public final String EmailAddress()
    {
        return this.EmailAddress;
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

        return this.MiddleInitial;

    }

    public final String getPassword()
    {
        return this.Password;

    }

    public final String MiddleInitial()
    {

        return this.MiddleInitial;

    }

     public final int getUserID()
     {
        return this.UserID;

     }

    public final int getMembership()
    {
        return this.Membership;
    }

    
    public final boolean getAllowAdmin()
    {
        return this.AllowAdmin;
    }
