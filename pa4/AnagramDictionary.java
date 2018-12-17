// Name: Jianan Gao
// USC NetID: 7450905127
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.io.File;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   

	Map<String,ArrayList<String>> dict;
   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
	   
	  dict = new HashMap<String,ArrayList<String>>();
	  File inFile = new File(fileName);
      Scanner in = new Scanner(inFile);
      while(in.hasNext()) {
    	  String word = in.next();
    	  //push all words in its place according to its canonical form
    	  if(dict.containsKey(sort(word))) {
    		  ArrayList<String> listAnagram = dict.get(sort(word));
    		  listAnagram.add(word);
    		  
    		  
    	  }
    	  else {
    		  ArrayList<String> listAnagram = new ArrayList<String>();
    		  listAnagram.add(word);
    		  dict.put(sort(word),listAnagram);
    	  }
      }
      in.close();
      
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
	   return dict.get(sort(s)); 
   }
   /*sort the string into the canonical version.
    * @param a string
    * @return the canonical version of the string.
    */
   private static String sort(String word) {
	   char[] wordArray = word.toCharArray();
	   Arrays.sort(wordArray);
	   return new String(wordArray);
	   
   }
   
   
}
