/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab2;
import java.util.Arrays;
/**
 *
 * @author Ethan
 */
public class AnagramChecker {
    //Requires: All strings are alphanumeric or spaces and are not null
    //Modifies: Modifies no inputs new arrays are being created in order to manipulate and compare strings
    //Effects: This method will change all input strings to lowercase and remove all spaces. It will then change them into a list of char to be murated and sorted
    // Once sorted the two arrays will be compared and if they are identical they will be anagrams
    public static boolean areAnagrams(String str1, String str2){
        char word1[] = (str1.toLowerCase()).replaceAll(" ","").toCharArray(); // changes all strings to all lowercase and turns them into arrays and gets rid of spaces
        char word2[] = (str2.toLowerCase()).replaceAll(" ","").toCharArray();
         
        
        
        Arrays.sort(word1);
        Arrays.sort(word2);
         
         
         return Arrays.equals(word1, word2);// 
    }
    
    public static void main(String[] args) {
        if(args.length == 2) {
            System.out.println(areAnagrams(args[0],args[1]));
        }
    }
}
