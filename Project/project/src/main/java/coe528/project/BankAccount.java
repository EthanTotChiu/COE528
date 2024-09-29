package coe528.project;

import java.io.IOException;


/**
 * Overview: BankAccount is a mutable class that represents a BankAccount in the banking application.
 * BankAccount has a account with a balance, and a level.

 * Abstraction Function:
 * Represents a bank account in the banking application as a BankAccount object where the account, balance, and customer level are represented by the respective fields.

 * Representation Invariant:
 * The 'account' must not be null.
 * The 'balance' must not be null or negative.
 */
public class BankAccount {
    //account name
    public static String account;
    //account balance
    private double balance;
    //account level
    protected Level lvl; // silver, gold, platinum
    //filehandler instance
    FileHandler file = new FileHandler(account);

    /**
     * Withdraws the specified amount from the customer's account.
     *
     * @param amount the amount to withdraw
     * @throws java.io.IOException if the file is not found
     * @requires amount > 0 and amount < balance
     * @modifies file, balance
     * @effects updates the balance of the text file
     * @return if the transaction was successful returns true else return false 
    */
    public boolean withdraw (double amount) throws IOException{
        getBal();
        updateLevel();
        if(amount > 0 && amount < balance){
            balance = file.getBal(account);
            balance = balance - amount;
            file.updateBal(account, balance);
            return true;
        }else{
            return false; 
        }
    } 
    /**
     * Withdraws the specified amount from the customer's account plus the purchase fee.
     *
     * @param amount the base amount to withdraw
     * @throws java.io.IOException if the file is not found
     * @requires amount > 0 and amount + fee < balance
     * @modifies file, balance
     * @effects updates the balance of the text file
     * @return if the transaction was successful returns true else return false 
    */
    public boolean purchase (double amount) throws IOException{
        getBal();
        updateLevel();
        if(amount > 0 && amount + lvl.fee() < balance){
            balance = file.getBal(account);
            balance = balance - amount - lvl.fee();
            file.updateBal(account, balance);
            return true;
        }else{
            return false; 
        }
    } 
    
    /**
     * Deposits the specified amount into the customer's account.
     *
     * @param amount the amount to deposit
     * @throws java.io.IOException if the file is not found
     * @requires amount > 0
     * @modifies file, balance
     * @effects updates the balance of the text file
     * @return if the transaction was successful returns true else return false 
     */
    public boolean deposit (double amount) throws IOException{
        getBal();
        updateLevel();
        if(amount > 0){
            balance = file.getBal(account);
            balance = balance + amount;
            file.updateBal(account, balance);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Returns the balance of the customer.
     * 
     * @throws java.io.IOException if the file is not found
     * @return the balance of the customer
     */
    public double getBal() throws IOException{
        balance = file.getBal(account);
        updateLevel();
        return balance;
    }
    
    /**
     * Updates the state of the level.
     * 
     * @modifies lvl
     */
    public void updateLevel(){
        if(balance < 10000.00){
            lvl = new Silver(this);
        }else if(balance < 20000.00){
            lvl = new Gold(this);
        }else{
            lvl = new Platinum(this);
        }
    }
    
    /**
     * Checks if the customer's account balance is non-negative and the account field is not null.
     *
     * @return true if the customer's account balance is non-negative and the account field is not null, false otherwise
     * @effects returns a Boolean indicating if the customer's account balance is non-negative and the account field is not null
     */
    public boolean repOk() {
        return balance >=0  && account != null;
    }
    
    /**
     * Returns a string representation of the customer level.
     *
     * @return a string representation of the customer level
     * @effects returns a string that represents the customer level
     */
    @Override
    public String toString() {
        return "Account: " + account + ", Balance: $" + balance + "Fee: $" + lvl.fee();
    }
}
