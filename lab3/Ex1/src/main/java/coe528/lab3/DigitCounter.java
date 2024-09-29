/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author Ethan
 */
public class DigitCounter extends AbstractCounter {
    //The current value of this Counter as a String of digits.
    public String count(){
        return Integer.toString(getValue());
    }
    
    //Increment this Counter.
    public void increment(){
        if (getValue() < 9)
            setValue(getValue()+1);
        else {
            setValue(0);
        }
    }
    //Decrement this Counter.
    public void decrement(){
        if (getValue() > 0)
            setValue(getValue()-1);
        else {
            setValue(9);
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
