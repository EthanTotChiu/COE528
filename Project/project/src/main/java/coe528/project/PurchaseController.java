package coe528.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PurchaseController extends BankAccount{
    @FXML
    private TextField value;
    
    @FXML
    private Label status;
    
    @FXML
    private Label newBal;
    
    @FXML
    private Label currentFee;
    
    @FXML
    private Label currentBal;
    
    
    @FXML
    public void initialize() throws IOException{
        getBal();
        currentFee.setText("The current fee is: $" + lvl.fee());
        currentBal.setText("Original Balance is: $" + getBal());
    }
    
    @FXML
    private void purchase() throws IOException {
        if(purchase(Double.parseDouble(value.getText())) && Double.parseDouble(value.getText())>50){
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
