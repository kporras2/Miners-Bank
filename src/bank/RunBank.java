package bank;

/**
 * @author Kevin Porras
 * @author Alex Sedeno-Gonzalez
 * 
 * 
 * @version
 * 
 * Date: October 23, 2024
 * Course: Advance Object Oriented Programming
 * Instructor: Gurijala, Bhanukiran
 * Project Part 1
 * 
 * 
 * Honesty Statement:
 * We hereby declare that we have completed this lab assignment entirely on our own. We have not used any unauthorized resources, including but not limited to:
 * Assistance from other students or individuals
 * Online resources such as websites, forums, or code repositories
 * Expert help or tutoring services
 * All the work submitted is our team's original effort, and I understand the consequences of academic dishonesty.
 * 
 */

import java.util.*;

public class RunBank {
    public static void main(String[] args) throws Exception {

        BankUtil bank = new BankUtil();
        CustomerMenu customerMenu = new CustomerMenu();
        ManagerMenu managerMenu = new ManagerMenu();
        Scanner menu_input = new Scanner(System.in);
        boolean inUse = true;
        boolean faliedLaunch = false;

        // Not good practice, IDE was having trouble finding the file, should just be "bank_users.csv"
        HashMap<String, Customer> users = bank.numerateData("/Users/kevin_portals/Desktop/80675448/Miners Bank/Miners Bank/src/bank/CS3331BankUsers.csv");
        if(users.isEmpty()){
            inUse = false;
            faliedLaunch = true;
            System.out.println("users is empty");
        }
        else{
            //System.out.print("Printing bank_users\n");
            //bank.printMap(users);
        }

        while(inUse){
    
            System.out.print("Welcome to the El Paso Miners Bank\n-----------------------------------------\n");
            System.out.print("What type of user are you, Individual or Bank Manager\n");
            System.out.print("Please type \"i\" for Indivdual and \"m\" for Manager or \"EXIT\" if you would like to exit\n");
            System.out.print(">");
            
            String userInput = menu_input.nextLine();

            switch (userInput) {
                case "i":
                    System.out.print("\nWelcome customer!\nPlease enter your (ID,Name)\n");
                    System.out.print(">");
                    String customerInput = menu_input.nextLine();
                    //break down input
                    String [] verifyCustomer = customerInput.trim().split(",");
                    //[0]ID, [1]Name
                    //check if the input is valid
                    if(verifyCustomer.length != 2){
                        //print srry input is not valid and kick them to main menu
                        System.out.println("\nInput is not valid, please try with format (ID, Name)\n");
                        break;
                    }
                    else{
                        if(bank.verifyCustomer(verifyCustomer[0], verifyCustomer[1], users)){
                            System.out.print("\n-----------------------------------------\n");
                            System.out.print("\nWelcome " + verifyCustomer[1] + " how can we assit you? \n\n");
                            Customer currCustomer = bank.getCurrentCustomer(verifyCustomer[0], verifyCustomer[1], users);
                            if(currCustomer == null){
                                break;
                            }
                            customerMenu.runCustomerMenu(users, currCustomer);
                        }
                        else{
                            System.out.println("You are not a customer");
                        }
                        break;
                    }
                    
                case "m":
                    System.out.print("Welcome manager, Please enter your credentials\n");
                    System.out.print(">");
                    String managerInput = menu_input.nextLine();
                    if(managerInput != null){ // here we would call manager credential function
                        System.out.print("\nWelcome " + managerInput + " how can we assit you? \n\n");
                        managerMenu.runManagerMenu();
                    }
                    break;
                case "EXIT":
                    inUse = false;
                    System.out.println("Thank you for using our bank, come back again");
                    break;
                default:
                    System.out.print("Invalid user option, try again!\n\n");
                    menu_input.next();
                    break;
            }

        }

        if(!faliedLaunch){
            bank.writeCsv(users, "/Users/kevin_portals/Desktop/80675448/Miners Bank/Miners Bank/src/CS3331BankUsers.csv");
        }
        menu_input.close();
        System.out.println("Leaving bank app");
    }

}
