package coe528.project;

public class Silver extends Level{
    
    public Silver(BankAccount Account){
        super(Account);
    }
    @Override
    public int fee(){
        return 20;
    }
    
}
