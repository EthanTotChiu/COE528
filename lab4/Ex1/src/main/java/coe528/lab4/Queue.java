package coe528.lab4;
import java.util.ArrayList;

public class Queue<T>{
    // Overview: Queues are mutable, bounded
    // collection of elements that operate in
    // FIFO (First-In-First-Out) order.

    // The abstraction function is:
    // A.F(c) = {c.items.get(i) | 0 <= i < c.items.size()}
    
    // The rep invariant is:
    // c.items != null &&
    // for all integers i, c.items.get(i) is not null
    
    private ArrayList<T> items;
    
// constructor
    public Queue() {
        // EFFECTS: Creates a new Queue object
        items = new ArrayList<>();
    }
    
    public void enqueue(T element) throws Exception{
        // MODIFIES: this
        // EFFECTS: Adds item to the end of the queue
        if(element == null) throw new Exception("null character entered");
        items.add(element);
    }
    
    public T dequeue() throws Exception{
        // MODIFIES: this
        // EFFECTS: Removes first element of queue
        if (items.isEmpty()) throw new Exception("Queue is empty");
        return items.remove(0);
    }
    
    public boolean isEmpty(){
        // EFFECTS: Returns true if the queue is empty, otherwise returns false
        return items.isEmpty();
    }
    
    public boolean repOK(){
        // EFFECTS: Returns true if the rep invariant holds for this
        // object; otherwise returns false
        if (items == null) return false;
        for (T item : items) {
            if (item == null) return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        // EFFECTS: Returns a string that contains the strings in the
        // stack and the top element. Implements the
        // abstraction function.
        String queue = "{";
        
        for(int i = 0; i < items.size() ; i++){
            queue += items.get(i) + ", ";
        }
        queue += "} The top element is " + items.get(items.size()-1);
        return queue;
    }
}
