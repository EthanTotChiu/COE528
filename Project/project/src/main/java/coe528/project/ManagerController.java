package coe528.project;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.File;


public class ManagerController {
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private Label status;
    
    
    //make new textfile with username as string, password as first element
    //100$ as second element and customer role as third element
    @FXML
    public void addCustomer()throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new FileReader(username.getText() + ".txt"));
            status.setText("User already Exists");
            reader.close();
        }catch(IOException e){
            if(username.getText().equals("")||password.getText().equals("")||username.getText().equals("admin")){
                status.setText("Username or Password not valid");
            }else{
                BufferedWriter writer = new BufferedWriter(new FileWriter(username.getText()+".txt"));
                writer.write(password.getText());
                writer.write("\ncustomer");
                writer.write("\n100");
                writer.close();
                status.setText("Customer added");
            }   
        }
    }
    
    //deletes customer given username
    @FXML
    public void removeCustomer()throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new FileReader(username.getText() + ".txt"));
            reader.close();
            if(!(username.getText().equals("admin"))){
                File f = new File(username.getText() + ".txt");
                if(f.delete()){
                    status.setText("User deleted");
                }else{
                    status.setText("User not deleted");
                }
            }else{
                status.setText("Can not delete admin");
            }
        }catch(IOException e){
            status.setText("User does not exist");
        }
    }
    
    @FXML
    private void logOut() throws IOException {
        App.setRoot("Login");
    }
}
