/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author Ethan
 */
public class LinkedDigitCounter extends AbstractCounter {
        
    private Counter leftNeighbor;
    
    public LinkedDigitCounter(Counter leftNeighbour) {
        this.leftNeighbor = leftNeighbour;
    }
    
    public String count(){
        return Integer.toString(getValue());
    }
    
    //Increment this Counter.
    public void increment(){
        if (getValue() < 9)
            setValue(getValue()+1);
        else {
            setValue(0);
            leftNeighbor.increment();
        }
    }
    //Decrement this Counter.
    public void decrement(){
        if (getValue() > 0)
            setValue(getValue()-1);
        else {
            setValue(9);
            leftNeighbor.decrement();
        }
    }
    //Reset this Counter.
    
    public void reset(){
        setValue(0);
    }
    
    @Override
    public String toString(){
        return Integer.toString(getValue());
    }
}
