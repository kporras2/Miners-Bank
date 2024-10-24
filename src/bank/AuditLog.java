package bank;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

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
 * 
 * The `AuditLog` class is responsible for logging transaction details to a file named "Log.txt".
 * It provides methods to write various types of banking transactions to the log file.
 */


public class AuditLog {

    // Not good practice, IDE was having trouble finding the file, should just be "Log.txt"
    static File filePath = new File("/Users/kevin_portals/Desktop/80675448/Miners Bank/Miners Bank/src/bank/Log.txt");
    protected static LocalDateTime dateTime;

    /**
     * Constructs an `AuditLog` object.
     */
    public AuditLog(){

    }

    
    /**
     * Writes a transaction log entry to the "Log.txt" file.
     *
     * @param typeOfTransaction The type of transaction being performed (e.g., "deposit-checking", "withdraw-saving").
     * @param amount            The amount of money involved in the transaction.
     * @param currentCustomer   The customer performing the transaction.
     * @param currentCustomer2  A second customer involved in the transaction (e.g., for transfers), or null if not applicable.
     */
    protected void writeLog(String typeOfTransaction, double amount, Customer currentCustomer, Customer currentCustomer2){
        //here we will write to the file
        //write to log file with message
        String message;
        if(currentCustomer2 == null){
            message = getMessgae(typeOfTransaction, amount, currentCustomer, null);
        }
        else{
            message = getMessgae(typeOfTransaction, amount, currentCustomer, currentCustomer2);
        }

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message);
            writer.write('\n');
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
        }
        

    }


    /**
     * Generates a log message based on the transaction type and customer details.
     *
     * @param typeOfTransaction The type of transaction.
     * @param amount            The transaction amount.
     * @param customer1         The primary customer involved.
     * @param customer2         A secondary customer involved (if applicable).
     * @return The formatted log message.
     */
    private String getMessgae(String typeOfTransaction, double amount, Customer customer1, Customer customer2){
        String message ="";
        switch (typeOfTransaction) {
            case "deposit-checking":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " deposited $"+amount+" to Checking-"+customer1.checking.getAccountNumber()+". " + customer1.getFirstName()+ " " +customer1.getLastName()+  " Balance for Checking-" +customer1.checking.getAccountNumber()+": $" + customer1.checking.getBalance();
                break;
            
            case "deposit-saving":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " deposited $"+amount+" to Saving-"+customer1.saving.getAccountNumber()+". " + customer1.getFirstName()+ " " +customer1.getLastName()+  " Balance for Saving-" +customer1.saving.getAccountNumber()+": $" + customer1.saving.getBalance();
                break;

            case "deposit-credit":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " deposited $"+amount+" to Credit-"+customer1.creditAccount.getAccountNumber()+". " + customer1.getFirstName()+ " " +customer1.getLastName()+  " Balance for Credit-" +customer1.creditAccount.getAccountNumber()+": $" + customer1.creditAccount.getBalance();
                break;

            case "withdraw-saving":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " withdrew $"+amount+" in cash from Saving-"+customer1.saving.getAccountNumber()+". " + customer1.getFirstName()+ " " +customer1.getLastName()+  " Balance for Saving-" +customer1.saving.getAccountNumber()+": $" + customer1.saving.getBalance();
                break;

            case "withdraw-checking":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " withdrew $"+amount+" in cash from Checking-"+customer1.checking.getAccountNumber()+". " + customer1.getFirstName()+ " " +customer1.getLastName()+  " Balance for Checking-" +customer1.checking.getAccountNumber()+": $" + customer1.checking.getBalance();
                break;

            case "withdraw-credit":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ "withdrew $"+amount+" in cash from Credit-"+customer1.creditAccount.getAccountNumber()+". " + customer1.getFirstName()+ " " +customer1.getLastName()+  " Balance for Credit-" +customer1.creditAccount.getAccountNumber()+": $" + customer1.creditAccount.getBalance();
                break;

            case "inquire-saving":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " made a balance inquiry on Saving-"+customer1.saving.getAccountNumber()+". "+customer1.getFirstName()+ " " +customer1.getLastName() +" Balance for Saving-"+customer1.saving.getAccountNumber()+": $" + customer1.saving.getBalance();
                break;

            case "inquire-checking":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " made a balance inquiry on Checking-"+customer1.checking.getAccountNumber()+". "+customer1.getFirstName()+ " " +customer1.getLastName() +" Balance for Checking-"+customer1.checking.getAccountNumber()+": $" + customer1.checking.getBalance();
                break;

            case "inquire-credit":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " made a balance inquiry on Credit-"+customer1.creditAccount.getAccountNumber()+". "+customer1.getFirstName()+ " " +customer1.getLastName() +" Balance for Checking-"+customer1.creditAccount.getAccountNumber()+": $" + customer1.creditAccount.getBalance();
                break;

            case "transfer-checking-saving":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " transferred $"+ amount+ " from Checking-"+customer1.checking.getAccountNumber()+" to Saving-"+customer1.saving.getAccountNumber()+". "+customer1.getFirstName()+ " " +customer1.getLastName()+  " Balance for Checking-" +customer1.checking.getAccountNumber()+": $" + customer1.checking.getBalance()+". "+customer1.getFirstName()+ " " +customer1.getLastName()+  "Balance for Saving-" +customer1.saving.getAccountNumber()+": $" + customer1.saving.getBalance();
                break;
            
            case "transfer-saving-checking":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " transferred $"+ amount+ " from Saving-"+customer1.saving.getAccountNumber()+" to Checking-"+customer1.checking.getAccountNumber()+". "+customer1.getFirstName()+ " " +customer1.getLastName()+  " Balance for Savings-" +customer1.saving.getAccountNumber()+": $" + customer1.saving.getBalance()+". "+customer1.getFirstName()+ " " +customer1.getLastName()+  "Balance for Checking-" +customer1.checking.getAccountNumber()+": $" + customer1.checking.getBalance();

                break;
            case "pay-saving":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " paid "+ customer2.getFirstName()+ " " +customer2.getLastName()+ " $"+amount+" from Saving-"+customer1.saving.getAccountNumber()+". " +customer1.getFirstName()+ " " +customer1.getLastName()+" New Balance for Saving-"+customer1.saving.getAccountNumber()+": $" + customer1.saving.getBalance() +". "+customer2.getFirstName()+ " " +customer2.getLastName()+ "received "+amount+"from " +customer1.getFirstName()+ " " +customer1.getLastName() +". "+customer2.getFirstName()+ " " +customer2.getLastName()+  "Balance for Checking-" +customer2.checking.getAccountNumber()+": $" + customer2.checking.getBalance();
                break;
            
            case "pay-checking":
                message = "Time and Date: "+dateTime.now()+" | "+ customer1.getFirstName()+ " " +customer1.getLastName()+ " paid "+ customer2.getFirstName()+ " " +customer2.getLastName()+ " $"+amount+" from Checking-"+customer1.checking.getAccountNumber()+". " +customer1.getFirstName()+ " " +customer1.getLastName()+" New Balance for Checking-"+customer1.checking.getAccountNumber()+": $" + customer1.checking.getBalance() +". "+customer2.getFirstName()+ " " +customer2.getLastName()+ "received "+amount+"from " +customer1.getFirstName()+ " " +customer1.getLastName() +". "+customer2.getFirstName()+ " " +customer2.getLastName()+  "Balance for Checking-" +customer2.checking.getAccountNumber()+": $" + customer2.checking.getBalance();
                break;
        
            default:
                message = "Time and Date: "+dateTime.now()+" | "+" Invalid transaction";
                break;
        }

        return message;
    }

}
