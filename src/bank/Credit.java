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
 *
 * The `Credit` class represents a credit account in a banking system. It extends the `Account` class and
 * includes functionality to manage a credit limit.
 */
public class Credit extends Account{
    private double creditLimit;

    /**
     * Constructs a `Credit` object with the specified account number, initial balance, and credit limit.
     *
     * @param accNum      The account number for the credit account.
     * @param balance     The starting balance for the credit account.
     * @param creditLimit The credit limit for the account.
     */
    public Credit(int accNum, double balance, double creditLimit){
        super(accNum, balance);
        this.creditLimit = creditLimit;
    }

    /**
     * Checks if a given transaction amount would exceed the credit limit.
     *
     * @param attemptedAmount The amount of the attempted transaction.
     * @return `true` if the transaction would exceed the credit limit, `false` otherwise.
     */
    public boolean overLimit(double attemptedAmount){
        double balance = super.getBalance() - attemptedAmount;
        return (Math.abs(balance) >= creditLimit)? true: false;
    }

    /**
     * Returns the credit limit for the account.
     *
     * @return The credit limit.
     */
    public double getCreditLimit(){
        return this.creditLimit;
    }
} 
