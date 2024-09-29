/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author edchiu
 */
public abstract class Passenger {
    String name;
    int age;
    
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract double applyDiscount(double p);
    
    //getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    
}


