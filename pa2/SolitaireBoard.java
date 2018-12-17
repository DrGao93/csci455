// Name:Jianan Gao
// USC NetID: jiananga	
// CSCI455 PA2
// Fall 2018
import java.util.Random;

import java.util.ArrayList;

/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
  by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.
  (See comments below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   
   /**
      Representation invariant:
	 1) the sum of all the cards should be 45;
     2)each pile should have less or equal to 45;
     3) every element is larger than 0; 
      

   */
   
   // <add instance variables here>
	  int[] array ;
	  int currentLast;
	  int[] hasAll;
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
      Fill the internal array. initialize hasALl array.
      PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
	   array = new int[CARD_TOTAL+ NUM_FINAL_PILES*NUM_FINAL_PILES- NUM_FINAL_PILES];//index can not exceed this number
	   hasAll = new int[NUM_FINAL_PILES+1];

	   
	   for(int i=0;i<piles.size();i++) {
		   array[i] = piles.get(i);
	   }
	   currentLast = piles.size()-1;
      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }
 
   
   /**
      Creates a solitaire board with a random initial configuration.
      PRE:nothing, return nothing.
   */
   public SolitaireBoard() {
	   array = new int[CARD_TOTAL+ NUM_FINAL_PILES*NUM_FINAL_PILES- NUM_FINAL_PILES];
	   hasAll = new int[NUM_FINAL_PILES+1];
	   
	   
	   Random rand = new Random();
	   int i = 0;
	   int nextBound = CARD_TOTAL + 1;
	   do {
		   array[i] = rand.nextInt(nextBound);
		   nextBound = nextBound - array[i];
		   i++;
	   }while(sumArray(array)!=45);
	   currentLast = i;
	   assert isValidSolitaireBoard();

   }
   
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
      PRE: a board that is not done, return: nothing
   */
   public void playRound() {
	   
	   int sum = 0;

	   for(int i=0;i<array.length;i++) {
		   if(array[i] != 0) {
			   array[i] --;
			   sum ++;
			   
		   }
	   }
	   
	   array[currentLast+1] =  sum;
	   currentLast++;
   
	   
	   
	   assert isValidSolitaireBoard();
	   
   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
      PRE: board is not done.
   */
   
   public boolean isDone() {
	   
	  for(int i=0;i<NUM_FINAL_PILES+1;i++) {
	    	  hasAll[i] = 0;
	      }
      
      for(int i=0;i<array.length;i++) {
    	  if(array[i]<=NUM_FINAL_PILES && array[i]>0) {
    		  hasAll[array[i]] ++;
    	  }
      }
      assert isValidSolitaireBoard();
      for(int i=1;i<NUM_FINAL_PILES+1;i++) {
    	  //assert isValidSolitaireBoard();
    	  if(hasAll[i] !=1) return false;
      }
      
      return true;  

   }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
   public String configString() {
	   String str = "";
	   String ret;
	  for(int i=0;i<array.length;i++) {
		  if(array[i]!=0) {
			  str += Integer.toString(array[i]) + " ";
			  
		  }
	  }
	  ret = str.substring(0,str.length()-1);
	  assert isValidSolitaireBoard();
      return ret;   
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   //problem
   private boolean isValidSolitaireBoard() {
	   int sum=0;
	   boolean ret;
	   boolean allBiggerThanZeroSmallerThanCardTotal = true;
	   boolean sumRight;
      for(int i=0;i<array.length;i++) {
    	  sum += array[i];
    	  if(array[i] <0 || array[i] > CARD_TOTAL) {
    		  allBiggerThanZeroSmallerThanCardTotal = false;
    	  }
      }
      if (sum==CARD_TOTAL) {
    	  sumRight = true;
      }else {
    	  sumRight = false;
      }
      return sumRight && allBiggerThanZeroSmallerThanCardTotal;  

   }
   

   // <add any additional private methods here>
   /*return the sum of the internal array.
    * */
   private static int sumArray(int[] array) {
	   int sum = 0;
	   for(int i=0;i<array.length;i++) {
		   sum += array[i]; 
	   }
	   //assert isValidSolitaireBoard();
	   return sum;
   }

}
