/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package coe528.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

/**
 *
 * @author edchiu
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    Flight f1 = new Flight(1, "Toronto", "Ottowa", "03/02/99 7:50 pm",100,1000.0);   
    Flight f2 = new Flight(1, "Toronto", "France", "03/02/99 7:50 pm",3,1000.0);
    
    /**
     * Test of constructor method, of class Flight.
     */
    @Test
    public void testConstructor() {
        System.out.println("valid constructor");
        Flight instance = f1;
        assertEquals(1,instance.getFlightNumber());
        assertEquals(100,instance.getCapacity());
        assertEquals("Toronto" ,instance.getOrigin());
        assertEquals("Ottowa" ,instance.getDestination());
        assertEquals("03/02/99 7:50 pm" ,instance.getDepartureTime());
        assertEquals(1000.0 ,instance.getOriginalPrice());
        
        
    }
    
    @Test
    public void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class,()->{
        new Flight(1, "Toronto", "Toronto", "03/02/99 7:50 pm",100,1000.0);
        });
        System.out.println("invalid constructor");
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
        Flight instance = f1;
        boolean expResult = true;
        boolean result = instance.bookASeat();
        assertEquals(99, instance.getNumberOfSeatsLeft());
    }

    @Test
    public void testBookASeatFull() {
        System.out.println("bookASeatFull");
        Flight instance = f2;
        for(int i = 0; i < 3; i++){
            assertTrue(instance.bookASeat());
        }
        assertFalse(instance.bookASeat());
        assertEquals(0, instance.getNumberOfSeatsLeft());
    }
    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Flight instance = f1;
        String expResult = "Flight 1, Toronto to Ottowa, 03/02/99 7:50 pm, original price: 1000.0$";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}