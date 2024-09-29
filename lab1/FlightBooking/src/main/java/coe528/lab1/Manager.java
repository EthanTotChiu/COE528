/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author edchiu
 */
public class Manager {
    private Flight[] flights;
    private Ticket[] tickets;
    
    public void createFlights(){
        flights[0] = new Flight(1, "Toronto", "Ottowa", "03/11/24 7:50 pm",20,1000.0);
        flights[1] = new Flight(2, "Toronto", "France", "08/23/23 7:50 pm",60,2000.0);
        flights[2] = new Flight(3, "Toronto", "Germany", "04/01/24 7:50 pm",5,3000.0);
    }
    
    public void displayAvailableFlights(String origin, String destination){
        System.out.println("Flights from " + origin + " to " + destination + " are:");
        for (Flight flight : flights) {
            if (flight != null) {
                if (flight.getOrigin().equals(origin)  && flight.getDestination().equals(destination)) {
                    System.out.println(flight.toString());
                }
            }                
        }
    }
    
    public Flight getFlight(int flightNumber){
        for (Flight flight : flights) {
            if(flight.getFlightNumber() == flightNumber){
                return flight;
            }
            else
                System.out.println("There exists no flight with that number");
        }
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        for (Flight flight : flights) {
            if (flight != null && flight.getFlightNumber() == flightNumber) {
                if (flight.getNumberOfSeatsLeft() > 0) {
                    Ticket ticket = new Ticket(p, flight, p.applyDiscount(flight.getOriginalPrice()));
                    flight.bookASeat();
                    tickets[Ticket.getNumber()] =  ticket;
                    System.out.println("Ticket booked");
                    System.out.println(ticket.toString());
                }else{
                    System.out.println("Seats on Flight#:" + flightNumber + " are full");
                }
                
            }
        }
    }
    
    public static void main(String[] args ){
        Manager airPort = new Manager();
        // create three flights
        airPort.createFlights();
        // test Manger functions
        airPort.displayAvailableFlights("Toronto", "Germany");
        
        System.out.println(airPort.getFlight(1));
        
        // create 4 passengers -> add to flight
        Member p1 = new Member (7, "Passenger1", 42);
        Member p2 = new Member (2, "Passenger2", 42);
        NonMember p3 = new NonMember ("Passenger3", 70);
        NonMember p4 = new NonMember ("Passenger4", 40);
        
        airPort.bookSeat(1,p1);
        airPort.bookSeat(2,p2);
        airPort.bookSeat(3,p3);
        airPort.bookSeat(1,p4);
        
    }
    
}
