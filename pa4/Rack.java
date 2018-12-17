// Name: Jianan Gao	
// USC NetID: 7450905127
// CS 455 PA4
// Fall 2018


import java.util.*;
/**
   A Rack of Scrabble tiles
 */

public class Rack {
   

	//instance variable storing unique string and multiplicity.
	private String unique;
	private int[] mult;
	
	/**
    Constructor of rack
    @param a string to be made as a rack
    @author Jianan Gao
  */
	public Rack(String rackString) {
		HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
		//mult = new int[rackString.length()];
		char[] charArray = rackString.toCharArray();
		for(char letter : charArray) {
			Character charObj = new Character(letter);
			if(charMap.containsKey(charObj)){
				charMap.put(charObj,charMap.get(charObj)+1);
			}else {
				charMap.put(charObj,1);
			}
		}
		int i = 0;
		unique = "";
		mult = new int[charArray.length];
		for(Map.Entry<Character,Integer> entry : charMap.entrySet()) {
			unique += entry.getKey();
			mult[i] = entry.getValue();
			
			i++;
			
		}
		
		
	}
	/*Wrapper method for all subsets.
	 * 
	 */
	public ArrayList<String> Subsets(){
		return allSubsets(this.unique,this.mult,0);
	}
	
   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
}
