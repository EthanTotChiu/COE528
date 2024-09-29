package coe528.project;

public abstract class Level{
    protected BankAccount Account;
    
    public Level(BankAccount Account){
        this.Account = Account;
    }
    
    public abstract int fee();
}