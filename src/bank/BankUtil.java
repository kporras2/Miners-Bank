package bank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
 * The `BankUtil` class provides utility functions for managing customer data in a banking system.
 * It includes methods for reading customer data from a file, writing data to a CSV file, 
 * printing customer information, verifying customer credentials, and retrieving customer objects.
 */


public class BankUtil {
    
    /**
     * Constructs a `BankUtil` object.
     */
    BankUtil(){ 

    }

    /**
     * Reads customer data from a file and populates a HashMap with the data.
     *
     * @param filename The name of the file containing customer data.
     * @return A HashMap where the keys are customer IDs and the values are `Customer` objects.
     */
    public HashMap<String, Customer>numerateData(String filename){
        try{
            HashMap<String, Customer> customers = new HashMap<>();
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);
            fileReader.nextLine();
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String [] data = line.trim().split(",");
                System.out.println("Length of data: "+ data.length);
                //[0]Identification Number,[1]First Name,[2]Last Name,[3]Date of Birth,[4,5, 6]Address,[7]Phone Number,
                //[8]Checking Account Number,[9]Checking Starting Balance,[10]Savings Account Number,
                //[11]Savings Starting Balance,[12]Credit Account Number,[13]Credit Max,[14]Credit Starting Balance
                System.out.println(Arrays.toString(data));
                //Key: ID, Value: data array
                Customer curr = new Customer(data[0], data[1],data[2], data[3],(data[4]+data[5]+data[6]), data[7],Integer.parseInt(data[8]), Double.parseDouble(data[9]), 
                                            Integer.parseInt(data[10]), Double.parseDouble(data[11]), Integer.parseInt(data[12]), 
                                            Double.parseDouble(data[14]), Double.parseDouble(data[13]));
                
                //String id, String firstName, String lastName, String DOB, String address, String phoneNumber,int checkingsAccountNum, double checkingsBalance,int savingsAccountNum, double savingsBalance, 
               //int creidtAccountNum, double creditBalance, double creditLimit
                
                customers.put(data[0], curr);
            }

            return customers;
        }
        catch(Exception e){
            System.out.println("Error reading file");
            System.out.println("This was the error: "+e);
            return new HashMap<String, Customer>();
        }
    }

    
    /**
     * Writes customer data from a HashMap to a CSV file.
     *
     * @param table    The HashMap containing customer data.
     * @param filename The name of the CSV file to be written.
     */
    public void writeCsv(HashMap<String, Customer> table, String filename){
        FileWriter filewriter  = null;
        
        try {
            filewriter = new FileWriter(filename);
            filewriter.append("Identification Number,First Name,Last Name,Date of Birth,Address,Phone Number,Checking Account Number,Checking Starting Balance,Savings Account Number,Savings Starting Balance,Credit Account Number,Credit Max,Credit Starting Balance\n");
            for(Customer curr: table.values()){
                filewriter.append(curr.getId()+","+curr.getFirstName()+","+curr.getLastName()+","+curr.getDOB()+","+curr.getAddress()+","+String.valueOf(curr.getPhoneNumber())+","+String.valueOf(curr.checking.getAccountNumber())+","+String.valueOf(curr.checking.getBalance())+","+String.valueOf(curr.saving.getAccountNumber())+","+String.valueOf(curr.saving.getBalance())+","+String.valueOf(curr.creditAccount.getAccountNumber())+","+String.valueOf(curr.creditAccount.getCreditLimit())+","+String.valueOf(curr.creditAccount.getBalance())+"\n");
            }
                
            System.out.print("csv file created\n");
        }catch (IOException e){
            System.out.print("error creating csv\n");
        }finally{
            try{
                if(filewriter != null){
                    filewriter.flush();
                    filewriter.close();
                    System.out.print("csv sucessfully saved\n");
                }
            }catch(IOException e){
                System.out.print("error closing filewriter\n");
            }

        }
    }


    /**
     * Prints the key-value pairs of a HashMap to the console.
     *
     * @param map The HashMap to be printed.
     */
    public void printMap(HashMap<String, Customer> map){
        for(Map.Entry<String, Customer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    /**
     * Verifies if a customer exists in the system based on their ID and first name.
     *
     * @param id        The customer's ID.
     * @param firstName The customer's first name.
     * @param users     The HashMap containing customer data.
     * @return `true` if the customer is found, `false` otherwise.
     */
    public boolean verifyCustomer(String id, String firstName, HashMap<String, Customer> users){
        if(users.containsKey(id) && users.get(id).getFirstName().equals(firstName)){
            return true;
        }
        return false;
    }


    /**
     * Retrieves a `Customer` object from the HashMap based on their ID and first name.
     *
     * @param id        The customer's ID.
     * @param firstName The customer's first name.
     * @param users     The HashMap containing customer data.
     * @return The `Customer` object if found, or null if not found.
     */
    public Customer getCurrentCustomer(String id, String firstName, HashMap<String, Customer> users){
        if(users.containsKey(id) && users.get(id).getFirstName().equals(firstName)){
            return users.get(id);
        }
        else{
            System.out.println("You are not a customer in our registry");
            return null;
        }
    }

}
