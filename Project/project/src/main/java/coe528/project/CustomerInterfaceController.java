package coe528.project;

import static coe528.project.BankAccount.account;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CustomerInterfaceController {

    FileHandler file = new FileHandler(account);
    
    @FXML
    private Label currentBal;
    
    @FXML
    public void initialize() throws IOException{
        currentBal.setText("Current Balance is: $" + file.getBal(account));
    }
    
    @FXML
    private void switchToDeposit() throws IOException {
        App.setRoot("DepositInterface");
    }
    
    @FXML
    private void switchToWithdraw() throws IOException {
        App.setRoot("WithdrawInterface");
    }
    
    @FXML
    private void switchToPurchase() throws IOException {
        App.setRoot("PurchaseInterface");
    }
    
    @FXML
    private void logOut() throws IOException {
        App.setRoot("Login");
    }
}