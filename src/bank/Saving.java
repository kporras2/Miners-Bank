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
 * The `Saving` class represents a savings account in a banking system. It extends the `Account` class
 * and includes functionality to check if the account balance is below the minimum required balance.
 */
public class Saving extends Account{
    boolean belowMinimum;

    /**
     * Constructs a `Saving` object with the specified account number and initial balance.
     *
     * @param accNum  The account number for the savings account.
     * @param balance The starting balance for the savings account.
     */
    public Saving(int accNum, double balance){
        super(accNum, balance);
    }

    /**
     * Checks if the savings account balance is above the minimum required balance.
     *
     * @return `true` if the balance is above the minimum, `false` otherwise.
     */
    public boolean checkMinimumBalance(){
        double balance = super.getBalance();
        return (balance >10)? true: false;
    }
}
