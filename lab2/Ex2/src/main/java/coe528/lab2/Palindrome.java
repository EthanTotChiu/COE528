/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab2;

/**
 *
 * @author Ethan
 */
public class Palindrome {
    //Requires: <Method will work as long as there is a string input that is not null in which it will print 'Flase'>
    //Modifies: <Method modified no inputs, it creates a new reverse string instead>
    //Effects: <Method creates a new string that is the original string but reversed and compares it to original string with .equals. Then prints true if Palindrome and false otherwisse>
    public static boolean isPalindrome(String a) {
        String reverse = null;
        
        for (int i = a.length() - 1; i >= 0; i--) {
            reverse = reverse + a.charAt(i);
        }
        
        return a.equals(reverse);
    }
    
    public static void main(String[] args) {
        if(args.length == 1) {
            if(args[0].equals("1"))
                System.out.println(isPalindrome(null));
            else if (args[0].equals("2"))
                System.out.println(isPalindrome(""));
            else if (args[0].equals("3"))
                System.out.println(isPalindrome("deed"));
            else if (args[0].equals("4"))
                System.out.println(isPalindrome("abcd"));
        }
    }
}

