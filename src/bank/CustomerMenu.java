package bank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Kevin Porras
 * @author Alex Sedeno-Gonzalez
 * 
 * 
 * Date: October 23, 2024
 * Course: Advance Object Oriented Programming
 * Instructor: Gurijala, Bhanukiran
 * Project Part 1
 * 
 * 
 * The `CustomerMenu` class provides a command-line interface for customers to interact with their bank accounts.
 * It allows customers to perform actions such as inquiring about balances, depositing funds, withdrawing funds,
 * transferring funds between accounts, and making payments to other customers.
 */
public class CustomerMenu {

    /**
     * Runs the customer menu interface, allowing the customer to perform various banking operations.
     *
     * @param users            The HashMap containing all registered customers in the banking system.
     * @param currentCustomer The `Customer` object representing the currently logged-in customer.
     */
    public void runCustomerMenu(HashMap<String, Customer> users, Customer currentCustomer){
        Scanner customerInput = new Scanner(System.in);
        Transaction transaction = new Transaction();
        boolean inUse = true;
        while(inUse){
            
            System.out.println("As a customer you can: "+
                                "\n----------------------------\n" +
                                "-Inquire about balance \"i\""+
                                "\n-Deposit money to an account \"d\""+
                                "\n-Withdraw money from an account \"w\""+
                                "\n-Transfer money between accounts \"t\""+
                                "\n-Pay someone \"p\""+
                                "\n-Exit customer menu \"EXIT\""+
                                "\n----------------------------\n");
            
            
            System.out.println("Please type the corresponding letter to the action you wish to commit ex. \">i\"\n");
            System.out.print(">");
            
            String input = customerInput.nextLine();
            System.out.print("\n");

            switch (input) {
                case "i":
                    System.out.println("Inquiring about balance\n----------------------------\n");

                    System.out.println("Please enter information accurately, it is case sensitive");
                    System.out.println("What account would you like to know the balance of?");

                    System.out.println("Saving Account Number: " +currentCustomer.saving.getAccountNumber()+"\n"+
                                        "Checking Account Number: " +currentCustomer.checking.getAccountNumber()+"\n"+
                                        "Credit Account Number: " +currentCustomer.creditAccount.getAccountNumber()+"\n");

                    System.out.print(">");
                    String accNum = customerInput.nextLine().trim();

                    transaction.inquireBalance(Integer.parseInt(accNum),currentCustomer);
                    break;
                case "d":
                    System.out.println("Deposit money to account\n----------------------------\n");
                    
                    System.out.println("Please enter information accurately, it is case sensitive");
                    System.out.println("What account would you like to deposit to?\n");

                    System.out.println("Saving Account Number: " +currentCustomer.saving.getAccountNumber()+"\n"+
                                        "Checking Account Number: " +currentCustomer.checking.getAccountNumber()+"\n"+
                                        "Credit Account Number: " +currentCustomer.creditAccount.getAccountNumber()+"\n");

                    System.out.print(">");
                    String depNum = customerInput.nextLine().trim();
                    System.out.println("How much would you like to deposit\n");
                    System.out.print(">");
                    String depAmount = customerInput.nextLine().trim();

                    transaction.deposit(Integer.parseInt(depNum), Double.parseDouble(depAmount), currentCustomer);
                    break;
                
                case "w":
                    System.out.println("Withdraw money from account\n----------------------------\n");

                    System.out.println("Please enter information accurately, it is case sensitive");
                    System.out.println("What account would you like to withdraw from?\n");

                    System.out.println("Saving Account Number: " +currentCustomer.saving.getAccountNumber()+"\n"+
                                        "Checking Account Number: " +currentCustomer.checking.getAccountNumber()+"\n"+
                                        "Credit Account Number: " +currentCustomer.creditAccount.getAccountNumber()+"\n");

                    System.out.print(">");
                    String withNum = customerInput.nextLine().trim();
                    System.out.println("How much would you like to withdraw?\n");
                    System.out.print(">");
                    String withAmount = customerInput.nextLine().trim();

                    transaction.withdraw(Integer.parseInt(withNum), Double.parseDouble(withAmount), currentCustomer);
                    break;

                case "t":
                    System.out.println("Transfer money to account\n----------------------------\n");

                    System.out.println("Please enter information accurately, it is case sensitive");
                    System.out.println("What account would you like to transfer from?\n");

                    System.out.println("Saving Account Number: " +currentCustomer.saving.getAccountNumber()+"\n"+
                                        "Checking Account Number: " +currentCustomer.checking.getAccountNumber()+"\n"+
                                        "Credit Account Number: " +currentCustomer.creditAccount.getAccountNumber()+"\n");

                    System.out.print(">");
                    String accSrc = customerInput.nextLine().trim();
                    System.out.println("What account would you like to transfer to?\n");

                    System.out.print(">");
                    String accDest = customerInput.nextLine().trim();
                    System.out.println("How much do you want to transfer?\n");
                    System.out.print(">");
                    String transferAmount = customerInput.nextLine().trim();

                    transaction.transfer(Integer.parseInt(accSrc), Integer.parseInt(accDest), Double.parseDouble(transferAmount), currentCustomer);
                    break;

                case "p":
                    System.out.println("Pay someone\n----------------------------\n");

                    System.out.println("Please enter information accurately, it is case sensitive");
                    System.out.println("Who would you like to pay, Please enter first name ?\n");
                    System.out.print(">");
                    String reciverFirstName = customerInput.nextLine().trim();

                    System.out.println("What is their last name?");
                    System.out.print(">");
                    String reciverLastName = customerInput.nextLine().trim();
                    Customer foundCustomer = null;
                    boolean found = false;

                    for (Map.Entry<String, Customer> entry : users.entrySet()) {
                        if (entry.getValue().getFirstName().equals(reciverFirstName) && entry.getValue().getLastName().equals(reciverLastName)) {
                            foundCustomer = entry.getValue();
                            found = true;
                        }
                    }

                    if(!found ||foundCustomer == null){
                        System.out.println("The person you are trying to pay doesnt exist");
                        break;
                    }

                    System.out.println("What account are you paying from?\n");
                    System.out.print(">");
                    String payingAcc = customerInput.nextLine().trim();

                    System.out.println("How much are you going to pay?\n");
                    System.out.print(">");
                    String amount = customerInput.nextLine().trim();

                    transaction.paySomeone(Integer.parseInt(payingAcc), Double.parseDouble(amount), currentCustomer, foundCustomer);
                    break;

                case"EXIT":
                    System.out.println("Exiting customer menu.....\n");
                    inUse = false;
                    break;

                default:
                    System.out.println("Invalid option try again!\n----------------------------\n");
                    break;
            }
            
        }

        return;
    }
}
