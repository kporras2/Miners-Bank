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
 * The `Account` class represents a generic bank account with a balance and account number. 
 * This class is intended to be an abstract class and serves as a base for more specific 
 * account types like checking, savings, or credit accounts.
 */

public abstract class Account {
    private int accNum;
    private double balance;

    /**
     * Constructs an `Account` object with the specified account number and initial balance.
     *
     * @param accNum  The account number for the account.
     * @param balance The starting balance for the account.
     */
    Account(int accNum, double balance){
        this. accNum = accNum;
        this.balance = balance;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return The account balance.
     */
    public double getBalance(){
        return this.balance;
    }

    /**
     * Sets the balance of the account to the specified amount.
     *
     * @param amount The new balance for the account.
     */
    public void setBalance(double amount){
        this.balance = amount;
    }

    /**
     * Returns the account number.
     *
     * @return The account number.
     */
    public int getAccountNumber(){
        return this.accNum;
    }
}
