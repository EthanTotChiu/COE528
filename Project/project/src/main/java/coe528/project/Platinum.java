package coe528.project;

public class Platinum extends Level {
    public Platinum(BankAccount Account){
        super(Account);
    }
    
    @Override
    public int fee(){
        return 0;
    }
    
}
