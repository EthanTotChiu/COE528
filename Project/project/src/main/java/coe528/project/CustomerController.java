package coe528.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerController extends BankAccount{
       
    @FXML
    private TextField value;
    
    @FXML
    private Label status;
    
    @FXML
    private Label newBal;
    
    @FXML
    private Label currentBal;
    
    
    @FXML
    public void initialize() throws IOException{
        getBal();
        currentBal.setText("Original Balance is: $" + getBal());
    }
    
    @FXML
    private void deposit() throws IOException {        
        if(deposit(Double.parseDouble(value.getText()))){
            newBal.setText("New Balance: $"+ getBal());
            status.setText("Transaction Completed");
        }else{
            status.setText("Can not deposit negative ammount");
        }
    }
    
    @FXML
    private void withdraw() throws IOException {
        if(withdraw(Double.parseDouble(value.getText()))){
            newBal.setText("New Balance: $"+ getBal());
            status.setText("Transaction Completed");
        }else{
            status.setText("Not enough funds / invalid ammount");
        }
    }
    
    @FXML
    private void back() throws IOException {
        App.setRoot("CustomerInterface");
    }
    
    
}
