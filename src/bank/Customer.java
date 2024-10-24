package bank;
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
 * The `Customer` class represents a customer in a banking system. It extends the `Person` class and
 * includes information about the customer's credit account, savings account, and checking account.
 */
public class Customer extends Person {

    protected Credit creditAccount;
    protected Saving saving;
    protected Checking checking;

    //[0]Identification Number,[1]First Name,[2]Last Name,[3]Date of Birth,[4]Address,[5]Phone Number,
    //[6]Checking Account Number,[7]Checking Starting Balance,[8]Savings Account Number,
    //[9]Savings Starting Balance,[10]Credit Account Number,[11]Credit Max,[12]Credit Starting Balance

    /**
     * Constructs a `Customer` object with the specified details.
     *
     * @param id                The identification number of the customer.
     * @param firstName         The first name of the customer.
     * @param lastName          The last name of the customer.
     * @param DOB               The date of birth of the customer.
     * @param address           The address of the customer.
     * @param phoneNumber       The phone number of the customer.
     * @param checkingsAccountNum The account number for the checking account.
     * @param checkingsBalance  The starting balance for the checking account.
     * @param savingsAccountNum  The account number for the savings account.
     * @param savingsBalance     The starting balance for the savings account.
     * @param creidtAccountNum   The account number for the credit account.
     * @param creditBalance      The starting balance for the credit account.
     * @param creditLimit        The credit limit for the credit account.
     */
    Customer(String id, String firstName, String lastName, String DOB, String address, String phoneNumber,int checkingsAccountNum, double checkingsBalance,int savingsAccountNum, double savingsBalance, 
             int creidtAccountNum, double creditBalance, double creditLimit){

        //String firstName, String lastName ,String id, String phoneNumber, String DOB, String address
        super(firstName, lastName, id, phoneNumber, DOB, address);
        // int accNum, double balance, double creditLimit
        creditAccount = new Credit(creidtAccountNum, creditBalance, creditLimit);
        saving = new Saving(savingsAccountNum, savingsBalance);
        checking = new Checking(checkingsAccountNum, checkingsBalance);
    }


    /**
     * Returns a string representation of the `Customer` object, including all account details.
     *
     * @return A formatted string with customer and account information.
     */
    @Override
    public String toString() {
        return "ID: "+getId()+", First Name: "+getFirstName()+", Last Name: "+getLastName()+ ", DOB: "+getDOB()+"Address: " +getAddress()+", Phone Number: "+getPhoneNumber()+", Checkings Account: " +checking.getAccountNumber()+", Checkings Balance: "+checking.getBalance()+", Savings Account: "+saving.getAccountNumber()+", Savings Balance: "+saving.getBalance()+", Creidt Account: "+creditAccount.getAccountNumber()+", Credit Balance: "+creditAccount.getBalance()+", Credit Limit: "+creditAccount.getCreditLimit();
    }

}
