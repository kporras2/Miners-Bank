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
 * The `Transaction` class handles various banking transactions for customers, including deposits,
 * withdrawals, balance inquiries, transfers between accounts, and payments to other customers.
 * It also utilizes the `AuditLog` class to log transaction details.
 */
public class Transaction {
    private AuditLog logger;
    /**
     * Constructs a `Transaction` object and initializes the `AuditLog` for logging transactions.
     */
    public Transaction(){
        logger = new AuditLog();
    }

    /**
     * Deposits a specified amount into a customer's account.
     *
     * @param accNum    The account number to deposit into.
     * @param amount    The amount to deposit.
     * @param depositor The `Customer` object making the deposit.
     */
    protected void deposit(int accNum, double amount, Customer depositor){
        double adjustedAmount;
        //check if user is trying to deposit into savings
        if(depositor.saving.getAccountNumber() == accNum){

            adjustedAmount = (depositor.saving.getBalance()) + amount;
            depositor.saving.setBalance(adjustedAmount);
            System.out.println("Deposit to savings of $"+ amount +" successful!");
            logger.writeLog("deposit-saving", amount, depositor, null);
        }
        //check if user is trying to deposit into checking
        else if(depositor.checking.getAccountNumber() == accNum){

            adjustedAmount = (depositor.checking.getBalance()) + amount;
            depositor.checking.setBalance(adjustedAmount);
            logger.writeLog("deposit-checking", amount, depositor, null);
            System.out.println("Deposit to checkings of $"+ amount +" successful!");
        }
        //check if user is trying to deposit into credit
        else if(depositor.creditAccount.getAccountNumber() == accNum){
            //check if user has debt or payment is over current balance
            if(depositor.creditAccount.getBalance() == 0 || (depositor.creditAccount.getBalance() + amount) > 0){
                System.out.println("Your credit is payed off completely and/or payment is too big");
                return;
            }
            else{
                adjustedAmount = (depositor.creditAccount.getBalance()) + amount;
                depositor.creditAccount.setBalance(adjustedAmount);
                logger.writeLog("deposit-credit", amount, depositor, null);
                System.out.println("Deposit to credit of $"+ amount +" successful!");
            }
        }
        else{
            //user inputed an account that does not exsist
            System.out.println("Account does not exsist within your profile");
        }
    }
    
    /**
     * Withdraws a specified amount from a customer's account.
     *
     * @param accNum             The account number to withdraw from.
     * @param amount             The amount to withdraw.
     * @param withdrawlCustomer The `Customer` object making the withdrawal.
     */
    protected void withdraw(int accNum, double amount, Customer withdrawlCustomer){
        double adjustedAmount;
        //check if user is trying to withdraw from savings
        if(withdrawlCustomer.saving.getAccountNumber() == accNum){

            adjustedAmount = (withdrawlCustomer.saving.getBalance()) - amount;
            if(adjustedAmount <= 0){
                System.out.println("Withdraw amount is too high, Savings does not have funds!");
                return;
            }
            withdrawlCustomer.saving.setBalance(adjustedAmount);
            System.out.println("Withdraw from savings of $"+ amount +" successful!");
            logger.writeLog("withdraw-saving", amount, withdrawlCustomer, null);
        }
        //check if user is trying to withdraw from checking
        else if(withdrawlCustomer.checking.getAccountNumber() == accNum){

            adjustedAmount = (withdrawlCustomer.checking.getBalance()) - amount;
            if(adjustedAmount <= 0){
                System.out.println("Withdraw amount is too high, Checkings does not have funds!");
                return;
            }
            withdrawlCustomer.checking.setBalance(adjustedAmount);
            System.out.println("Withdraw from checkings of $"+ amount +" successful!");
            logger.writeLog("withdraw-checking", amount, withdrawlCustomer, null);
        }
        //check if user is trying to withdraw from credit
        else if(withdrawlCustomer.creditAccount.getAccountNumber() == accNum){
            
            if(withdrawlCustomer.creditAccount.overLimit(amount)){
                System.out.println("Withdraw amount is too high, Credit account does not have funds");
            }
            else{
                adjustedAmount = (withdrawlCustomer.creditAccount.getBalance()) - amount;
                withdrawlCustomer.creditAccount.setBalance(adjustedAmount);
                System.out.println("Withdraw from credit of $"+ amount +" successful!");
            }
        }
        else{
            //user inputed an account that does not exsist
            System.out.println("Account does not exsist within your profile");
        }
    }


    /**
     * Inquires about the balance of a customer's account.
     *
     * @param accNum     The account number to inquire about.
     * @param inqCustomer The `Customer` object making the inquiry.
     */
    protected void inquireBalance(int accNum, Customer inqCustomer){
        if(inqCustomer.saving.getAccountNumber() == accNum){
            System.out.println("Balance of savings is $"+ inqCustomer.saving.getBalance());
            logger.writeLog("inquire-saving", inqCustomer.saving.getBalance(), inqCustomer, null);
        }
        //check if user is trying to deposit into checking
        else if(inqCustomer.checking.getAccountNumber() == accNum){
            System.out.println("Balance of checkings is $"+ inqCustomer.checking.getBalance());
            logger.writeLog("inquire-checking", inqCustomer.checking.getBalance(), inqCustomer, null);
        }
        //check if user is trying to deposit into credit
        else if(inqCustomer.creditAccount.getAccountNumber() == accNum){
            System.out.println("Balance of credit is $"+ Math.abs(inqCustomer.creditAccount.getBalance())+ " owed");
            logger.writeLog("inquire-credit", inqCustomer.creditAccount.getBalance(), inqCustomer, null);
        }
        else{
            //user inputed an account that does not exsist
            System.out.println("Account does not exsist within your profile");
        }
    }

    /**
     * Transfers funds between a customer's accounts.
     *
     * @param accSrc  The account number to transfer funds from.
     * @param accDest The account number to transfer funds to.
     * @param amount  The amount to transfer.
     * @param mover   The `Customer` object making the transfer.
     */
    protected void transfer(int accSrc, int accDest, double amount, Customer mover){
    
        if(mover.saving.getAccountNumber() == accSrc){

            if(mover.checking.getAccountNumber() == accDest){

                double currentAmount  = mover.saving.getBalance();
                mover.saving.setBalance(currentAmount-amount);
                double currentDestBalance = mover.checking.getBalance();
                mover.checking.setBalance(currentDestBalance + amount);
                logger.writeLog("transfer-checking-saving", amount, mover, null);
                System.out.println("Transfer from savings-" + accSrc+" to chekings-" + accDest +" was successful for amount: $" +amount);


            }
            else{
                System.out.println("That account does not exist in your profile, you cannot transfer to that account!");
            }
        }
        //check if user is trying to withdraw from checking
        else if(mover.checking.getAccountNumber() == accSrc){

            if(mover.saving.getAccountNumber() == accDest){

                double currentAmount  = mover.checking.getBalance();
                mover.checking.setBalance(currentAmount-amount);
                double currentDestBalance = mover.saving.getBalance();
                mover.saving.setBalance(currentDestBalance + amount);
                logger.writeLog("transfer-saving-checking", amount, mover, null);
                System.out.println("Transfer from checkings-" + accSrc+" to savings-" + accDest +" was successful for amount: $" +amount);

            }
            else{
                System.out.println("That account does not exist in your profile, you cannot transfer to that account!");
            }
        }
        else if(mover.creditAccount.getAccountNumber() == accSrc){
            System.out.println("You cannot tranfer from a credit account");
        }
        //check if user is trying to withdraw from credit
        else{
            //user inputed an account that does not exsist
            System.out.println("Account does not exsist within your profile");
        }
    }

    public void paySomeone(int accSrc, double amount, Customer sender, Customer reciver){
        if(sender.saving.getAccountNumber() == accSrc){
            if(sender.saving.getBalance() >= amount){
                double newBalance = sender.saving.getBalance() - amount;
                sender.saving.setBalance(newBalance);

                double currentDestAmount = reciver.checking.getBalance();
                currentDestAmount += amount;
                reciver.checking.setBalance(currentDestAmount);
                System.out.println("Paying " +reciver.getFirstName() +" "+ reciver.getLastName() + "$"+ amount+ "was successfull!");
                logger.writeLog("pay-saving", amount, sender, reciver);
            }
            
        }
        
        else if(sender.checking.getAccountNumber() == accSrc){
            if(sender.checking.getBalance() >= amount){
                double newBalance = sender.checking.getBalance() - amount;
                sender.checking.setBalance(newBalance);

                double currentDestAmount = reciver.checking.getBalance();
                currentDestAmount += amount;
                reciver.checking.setBalance(currentDestAmount);
                System.out.println("Paying " +reciver.getFirstName() +" "+ reciver.getLastName() + "$"+ amount+ "was successfull!");
                logger.writeLog("pay-checking", amount, sender, reciver);
            }
        }
        
        else if(sender.creditAccount.getAccountNumber() == accSrc){
            System.out.println("You cannot pay someone from credit account");
        }
        else{
            //user inputed an account that does not exsist
            System.out.println("Account does not exsist within your profile");
        }
    }
}
