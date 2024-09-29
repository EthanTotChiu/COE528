package coe528.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.io.BufferedReader;
import java.io.FileReader;


public class LoginController {
    protected BankAccount bankAccount = new BankAccount();
    
    @FXML
    private Label status;
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
        
    @FXML
    private void login(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(username.getText() + ".txt"));
            String pass = reader.readLine();
            String role = reader.readLine();
            
            if(password.getText().equals(pass) && role.equals("manager")){
                reader.close();
                App.setRoot("AdminPanel");
            }else if(password.getText().equals(pass)){
                BankAccount.account = username.getText();
                reader.close();
                App.setRoot("CustomerInterface");
            }else{
                status.setText("Username or Password is incorect");
                reader.close();
            }
        } catch(IOException e){
            status.setText("account does not exist");
        }
    }
}
