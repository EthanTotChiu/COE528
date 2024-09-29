package coe528.project;

public class Gold extends Level{
    public Gold(BankAccount Account){
        super(Account);
    }
    
    @Override
    public int fee(){
        return 10;
    }
    
}
