package coe528.lab4;

/**
 *
 * @author Ethan
 */
import java.util.ArrayList;
public class StackOfDistinctStrings {
    // Overview: StacksOfDistinctStrings are mutable, bounded
    // collection of distinct strings that operate in
    // LIFO (Last-In-First-Out) order.

    // The abstraction function is:
    // AF(c) = {c.items.get(i)|0 <= i < c.items.size()}
  
    // The rep invariant is:
    // c.items != null &&
    // all elements if items are Strings &&
    // no duplicates in c.items
    
   
    
        //the rep
    private ArrayList<String> items;
        // constructor
    public StackOfDistinctStrings() {
        // EFFECTS: Creates a new StackOfDistinctStrings object
        items = new ArrayList<String>();
    }
    public void push(String element) throws Exception {
        // MODIFIES: this
        // EFFECTS: Appends the element at the top of the stack
        // if the element is not in the stack, otherwise
        // does nothing.
        if(element == null) throw new Exception();
        if(false == items.contains(element))
        items.add(element);
    }
    public String pop() throws Exception {
        // MODIFIES: this
        // EFFECTS: Removes an element from the top of the stack
        if (items.size() == 0) throw new Exception();
        return items.remove(items.size()-1);
    }
    public boolean repOK() {
        // EFFECTS: Returns true if the rep invariant holds for this
        // object; otherwise returns false
        if (items == null){
            return false;
        }
        for (String item : items){
            if (item == null){
                return false;
            }
        }
        for (int i = 0 ; i < items.size() ; i++){
            for(int j = 0 ; j < items.size() ; i++){
                if(items.get(i).equals(items.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public String toString() {
        // EFFECTS: Returns a string that contains the strings in the
        // stack and the top element. Implements the
        // abstraction function.
        String stack = "{";
        
        for(int i = 0; i < items.size() ; i++){
            stack += items.get(i) + ", ";
        }
        stack += "} The top element is " + items.get(items.size()-1);
        return stack;
    }
}