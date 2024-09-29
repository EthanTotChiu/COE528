package coe528.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private String username;
    private String password;
    private String role;

    public FileHandler(String username) {
        this.username = username;
    }
    
    
    
    public void updateBal(String user, double value) throws FileNotFoundException, IOException{
        this.username = user;
        try (BufferedReader reader = new BufferedReader(new FileReader(username + ".txt"))) {
            password = reader.readLine();
            role = reader.readLine();
            
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(username + ".txt"))) {
            writer.write(password);
            writer.write("\n" + role);
            writer.write("\n" + value);
        }
    }
    
    public double getBal(String user) throws FileNotFoundException, IOException{
        this.username = user;
        try (BufferedReader reader = new BufferedReader(new FileReader(username + ".txt"))) {
            reader.readLine();
            reader.readLine();
            return Double.parseDouble(reader.readLine());
        }
    }
}
