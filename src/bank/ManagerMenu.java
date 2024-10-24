package bank;
import java.util.Scanner;

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
 * The `ManagerMenu` class provides a command-line interface for bank managers to access and
 * inquire about customer account information. It allows managers to search for accounts by 
 * customer name or by account type and number.
 */
public class ManagerMenu {

    /**
     * Runs the manager menu interface, providing options to inquire about customer accounts.
     */
    public void runManagerMenu(){
        boolean inUse = true;
        while(inUse){
            System.out.println("As a manager you can:" +
                                "\n----------------------------\n"+
                                "\nInquire account by name\"A\""+
                                "\nInquire account by type/number\"B\""+
                                "\n-Exit customer menu \"EXIT\""+
                                "\n----------------------------\n");
            System.out.println("Please type the corresponding letter to the action you wish to commit ex. \">i\"\n");
            System.out.print(">");

            Scanner manager_input = new Scanner(System.in);
            String managerInput = manager_input.nextLine();

            switch (managerInput) {
                case "A":
                    System.out.println("Inquire account by name\n----------------------------\n");
                    // Add logic here to handle account inquiry by name

                    break;

                case "B":

                    System.out.println("Inquire account by type/number. \n----------------------------\n");
                    // Add logic here to handle account inquiry by type/number

                    break;

                case "EXIT":
                    // Exit the manager menu
                    System.out.println("Exiting manager menu.....\n");
                    inUse = false;
                    break;
            
                default:
                    System.out.println("Invalid input try again!\n----------------------------\n");
                    break;
            }

        }
        
    }
    
}
