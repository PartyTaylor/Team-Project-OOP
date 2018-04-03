/*
 */
package mainstore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Taylor Jones
 * @author Emily Rodriguez 
 */
public class MainStore {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("|   UberStock MENU SELECTION  |");
        System.out.println("===============================");
        System.out.println("| Options:                    |");
        System.out.println("|        1. New Account       |");
        System.out.println("|        2. Login As User     |");
        System.out.println("|        3. Login As Admin    |");
        System.out.println("|        4. Exit              |");
        System.out.println("===============================");
        System.out.println("Select Option: ");
        int menuChoice;
        boolean newAcc = false;
        String userName = "", password = "";
        boolean caseOne = true, caseTwo = true, caseThree = true, caseTwoFirstLoop = true;
        UserAbstract user = new UserAbstract();
        while(!sc.hasNextInt()){
            System.out.println("Invalid selection");
            sc.nextLine();
        }
        menuChoice = sc.nextInt();
        switch(menuChoice){
            //will make a new account for the user and then will take them two the second case
            case 1: 
                while(caseOne){
                    newAcc = true;
                    System.out.println("Enter requested username:: ");
                    userName = sc.next();
                    System.out.println("Enter requested password:: ");
                    password = sc.next();
                    if(user.newAccount(userName, password)){
                        caseOne = false;
                        System.out.println("New Account Created!");
                    }
                    else{
                        System.out.println("Already have an account? (yes or anything) :: ");
                        if("yes".equals(sc.next()))
                            caseOne = false;
                        else{
                            System.out.println("Want to exit? (yes or anything) :: ");
                            if("yes".equals(sc.next()))
                                break;
                        }
                    }
                }
            //logs the user in and takes them to the other menu found bellow
            case 2:
                while(caseTwo){
                    caseTwo = caseTwoSet(caseTwoFirstLoop, newAcc, user);
                    caseTwoFirstLoop = false;
                }
                System.out.println("Thanks for visiting UberStock!");
                break;
            //logs the admin in and takes them to the admin menu
            case 3:
                while(caseThree){
                    caseThree = caseThreeSet();
                }
                System.out.println("Thanks for visiting UberStock!");
                break;
            //closes the program
            case 4:
                System.out.println("Thanks for visiting UberStock!");
                break;
            //default case call if input is invalid
            default:
                System.out.println("Invalid selection");
                break;
        }
    }
    
    public static boolean caseTwoSet(boolean caseTwoFirstLoop, boolean newAcc, UserAbstract user) throws FileNotFoundException{
        String userName = "", password = "";
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        boolean shoppingBool = true;
        //if this is the first loop through this menu it will log the user in or attempt to
        if(caseTwoFirstLoop){
            System.out.println("Thank you for being a Customer!");
            System.out.println("Enter username:: ");
            userName = sc.next();
            System.out.println("Enter password:: ");
            password = sc.next();
        }
        else{
            //if already ran threw once will just keep the old username and password given
            userName = user.userName;
            password = user.password;
        }
        if(user.isUserPass(userName, password)){
            System.out.println("===============================");
            System.out.println("|   UberStock User SELECTION  |");
            System.out.println("===============================");
            System.out.println("| Options:                    |");
            System.out.println("|      1. Shop                |");
            System.out.println("|      2. Update Password     |");
            if(user.isUClub())
                System.out.println("|      3.Check Rewards Amount |");
            else
                System.out.println("|      3.Uprgrade To UClub    |");
            System.out.println("|      4. Exit                |");
            System.out.println("===============================");
            System.out.println("Select Option: ");
            int menuChoice;
            while(!sc.hasNextInt()){
                System.out.println("Invalid selection");
                sc.nextLine();
            }
            menuChoice = sc.nextInt();
            switch(menuChoice){
                //takes the user to the shopping menu
                case 1:
                    while(shoppingBool){
                        shoppingBool = shopping(user, cart);
                    }
                    break;
                //allows the user to set up a new password
                case 2:
                    System.out.println("Enter new password:: ");
                    password = sc.next();
                    user.updatePassword(password);
                    user.closeUser();
                    break;
                case 3:
                    //here it checks if the user is a uclub member giving them the option to check rewards
                    if(user.isUClub()){
                        System.out.println("Your rewards amount is:: " + user.points());
                    }
                    //if they arnt this case is to allow a basic user to upgrade
                    else{
                        System.out.println("The Total Cost will be $19.95 Annually");
                        System.out.println("Do you accept?(yes or anything)");
                        if("yes".equals(sc.next())){
                            System.out.println("REDIRECTING TO PAYPAL(not really)!");
                            user.upgrade();
                            user.closeUser();
                        }
                        else{
                            System.out.println("Thank you for your time, hope you change your mind later!");
                        }
                    }
                    break;
                //exits the program
                case 4:
                    return false;
                //just in case their is an invalid selection choice
                default:
                    System.out.println("Invalid selection");
            }     
        }
        else{
            return false;
        }
        return true;
        
    }
    
    //Menu For Admin
    public static boolean caseThreeSet() throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        String userName = "";
        System.out.println("===============================");
        System.out.println("|   UberStock Admin SELECTION |");
        System.out.println("===============================");
        System.out.println("| Options:                    |");
        System.out.println("|      1. List Users          |");
        System.out.println("|      2. Show History        |");
        System.out.println("|      3. Exit                |");
        System.out.println("===============================");
        System.out.println("Select Option: ");
        Admin admin = new Admin();
        int menuChoice;
        while(!sc.hasNextInt()){
            System.out.println("Invalid selection");
            sc.nextLine();
        }
        menuChoice = sc.nextInt();
        switch(menuChoice){
            //this will print all the users for the admin
            case 1:
                admin.showAllUsers();
                break;
            //this will show the purchase history of a user
            case 2:
                System.out.println("Type Username you wish to view:: ");
                admin.showPurchaseHistory(sc.next());
                break;
            //breaks the loop
            case 3:
               return false; 
           //default case call if input is invalid
            default:
               System.out.println("Invalid selection");
        }
        return true;
    }
    
    public static boolean shopping(UserAbstract user, Cart cart)throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        BedBath bath = new BedBath();
        Decor decor = new Decor();
        Furniture furniture = new Furniture();
        Home home = new Home();        
        Kitchen kitchen = new Kitchen();
        Outdoor outdoor = new Outdoor();
        Rugs rugs = new Rugs();
        
        int itemNum = 0;
        int itemAmount = 0;
        
        System.out.println("===============================");
        System.out.println("|   UberStock Shop SELECTION  |");
        System.out.println("===============================");
        System.out.println("| Options:                    |");
        System.out.println("|      1. Bed and Bath        |");
        System.out.println("|      2. Kitchen             |");
        System.out.println("|      3. Furniture           |");
        System.out.println("|      4. Decor               |");
        System.out.println("|      5. Outdoor             |");
        System.out.println("|      6. Rugs                |");
        System.out.println("|      7. Home                |");
        System.out.println("|      8. Purchase Cart       |");
        System.out.println("|      9. Exit                |");
        System.out.println("===============================");
        System.out.println("Select Option: ");
        int menuChoice;
        while(!sc.hasNextInt()){
            System.out.println("Invalid selection");
            sc.nextLine();
        }
        menuChoice = sc.nextInt();
        switch(menuChoice){
            //allows the user to shop through the bed and bath selection
            case 1:
                bath.showAvailableItems();
                System.out.println("What would you like to purchase?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemNum = sc.nextInt();
                if(itemNum == 0)
                    return true;
                System.out.println("How many?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemAmount = sc.nextInt();
                cart.addCart(bath, itemNum, itemAmount);
                return true;
            //allows the user to shop through the kitchen selection
            case 2:
                kitchen.showAvailableItems();
                System.out.println("What would you like to purchase?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemNum = sc.nextInt();
                if(itemNum == 0)
                    return true;
                System.out.println("How many?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemAmount = sc.nextInt();
                cart.addCart(kitchen, itemNum, itemAmount);
                return true;
            //allows the user to shop through the furniture selection
            case 3:
                furniture.showAvailableItems();
                System.out.println("What would you like to purchase?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemNum = sc.nextInt();
                if(itemNum == 0)
                    return true;
                System.out.println("How many?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemAmount = sc.nextInt();
                cart.addCart(furniture, itemNum, itemAmount);
                return true;
            //allows the user to shop through the decor selection
            case 4:
                decor.showAvailableItems();
                System.out.println("What would you like to purchase?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemNum = sc.nextInt();
                if(itemNum == 0)
                    return true;
                System.out.println("How many?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemAmount = sc.nextInt();
                cart.addCart(decor, itemNum, itemAmount);
                return true;
            //allows the user to shop through the outdoor selection
            case 5:
                outdoor.showAvailableItems();
                System.out.println("What would you like to purchase?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemNum = sc.nextInt();
                if(itemNum == 0)
                    return true;
                System.out.println("How many?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemAmount = sc.nextInt();
                cart.addCart(outdoor, itemNum, itemAmount);
                return true;
            //allows the user to shop through the rug selection
            case 6:
                rugs.showAvailableItems();
                System.out.println("What would you like to purchase?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemNum = sc.nextInt();
                if(itemNum == 0)
                    return true;
                System.out.println("How many?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemAmount = sc.nextInt();
                cart.addCart(rugs, itemNum, itemAmount);
                return true;
            //allows the user to shop through the home selection
            case 7:
                home.showAvailableItems();
                System.out.println("What would you like to purchase?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemNum = sc.nextInt();
                if(itemNum == 0)
                    return true;
                System.out.println("How many?(enter item number or 0 for none");
                while(!sc.hasNextInt()){
                    System.out.println("Invalid selection");
                    sc.nextLine();
                }
                itemAmount = sc.nextInt();
                cart.addCart(home, itemNum, itemAmount);
                return true;
            //this will check the user out and add their cart to the rewards and purchase history
            case 8:
                double points = cart.printCart(user.isUClub());
                System.out.println("Do you accept?(yes or anything)");
                    if("yes".equals(sc.next())){
                        System.out.println("REDIRECTING TO PAYPAL(not really)!");
                        System.out.println("Purchase Complete!");
                        if(user.isUClub()){
                            user.updatePoints(points);
                        }
                        cart.updateHist(user.userName);
                        return false;
                    }
                    else{
                        System.out.println("Returning to menu!");
                        return true;
                    }
            //returns the stock of any items in cart and gets out of loop
            case 9:
               System.out.println("Warning cart will be lost!");
               System.out.println("Are you sure?(yes or anything)");
               if(sc.next().equals("yes"))
               {
                   cart.cancelCart();
                   return false;
               }
               return true;
            //this will just make sure their is no invalid selection choices
            default:
               System.out.println("Invalid selection");
               return true;
        }
    }   
}
