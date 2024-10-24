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
 * The `Checking` class represents a checking account in a banking system. It extends the `Account` class
 * and includes functionality to check for overdrafts.
 * 
 */
public class Checking extends Account{
    boolean overDraft;
    /**
     * Constructs a `Checking` object with the specified account number and initial balance.
     *
     * @param accNum  The account number for the checking account.
     * @param balance The starting balance for the checking account.
     */
    public Checking(int accNum, double balance){
        super(accNum, balance);
    }
    /**
     * Checks if the checking account is overdrawn (has a negative balance).
     *
     * @return `true` if the account is overdrawn, `false` otherwise.
     */
    public boolean overdrawn(){
        double balance = super.getBalance();
        this.overDraft = (balance < 0)? true: false;
        return overDraft;
    }
}
