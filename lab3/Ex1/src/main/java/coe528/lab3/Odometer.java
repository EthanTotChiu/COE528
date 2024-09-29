/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author Ethan
 */
public class Odometer {

    private AbstractCounter [] linkedList;
    private final int n;
    
    public Odometer(int length) {
        
        this.n = length;
        
        if(n < 1)
            throw new IllegalArgumentException("Number of digits in odometer must be at least 1");
        
        linkedList = new AbstractCounter [n];
        linkedList[0] = new DigitCounter();
        
        for (int i = 1; i < n; i++){
            linkedList[i] = new LinkedDigitCounter(linkedList[i-1]);
        }
    }   
    
    public String count(){
        String number = "";
        
        for (int i = 0; i < n; i++)
           number += linkedList[i];       
        return number;
    }
    
    public void increment(){
        linkedList[n-1].increment();
    }
    
    public void decrement(){
        linkedList[n-1].decrement();
    }
    
    public void reset(){
        for (int i = 0 ; i < n ; i++)
            linkedList[i].reset();
    }
}
