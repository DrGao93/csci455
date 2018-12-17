// Name:jianan gao
// USC NetID: jiananga
// CSCI455 PA2
// Fall 2018

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
   <add main program comment here>
   User will execute with potentially two flags -u for user input and -s for single step. 
   if no -s, initialization then step through all steps then done, if -s, each time wait 
   for a enter, print one step each time. if no -u, initialize the board with random setup.
*/

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;
      SolitaireBoard board1;
      Scanner in1 = new  Scanner(System.in);

      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }
      if(userConfig) {
    	  //manual input start
    	 boolean flagKeepAsking = true;
    	 boolean flagWrongInput = false;
    	 boolean flagFirstEnter = true;
         ArrayList<Integer> list = new ArrayList<Integer>();
        
         
    	 System.out.println("Number of total cards is "+SolitaireBoard.CARD_TOTAL);
         System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
         System.out.println("Please enter a space-separated list of positive integers followed by newline:");


         while(flagKeepAsking){
        	 
        	 
        	 if(!flagFirstEnter) {
        		//if first time enter, skip this step
        		 System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
        		 System.out.println("Please enter a space-separated list of positive integers followed by newline:");
        	 }
        	
        	 flagFirstEnter = false;
        	 list = new ArrayList<Integer>();
        	 
        	 
        	 String string = in1.nextLine();
             Scanner in2 = new  Scanner(string);
             while(in2.hasNext()){
                try {
                	int toAdd = in2.nextInt();
                	if(toAdd <1) {
                		flagWrongInput = true;
                		break;
                	}
                	list.add(toAdd);
                	
                }
                catch(Exception ex){
                	//System.out.println(ex); 
                	flagWrongInput = true;
                	//add int failed, break inner loop
                	break;
                	
                }
                
                
             }
             if(!flagWrongInput) {
            	 //System.out.println(sumList(list));
            	if(sumList(list) == SolitaireBoard.CARD_TOTAL) {
            		//done with outer loop
            		flagKeepAsking = false;
            	}
             //otherwise keep outer loop
             }else {
            	 //reset
            	 flagWrongInput = false;
             }
             
         }
       
         board1 = new SolitaireBoard(list);
         System.out.print("Initial configuration: "+board1.configString());
      }else {
    	  //random start
    	  board1 = new SolitaireBoard();
    	  System.out.print("Initial configuration: "+board1.configString());
      }
      
      if(singleStep) {
    	  //Scanner in3;
    	  int i = 1;
    	  do {
    		  //in3 = new Scanner(System.in);
    		  if(in1.hasNextLine()) {
    			  board1.playRound();
    			  
    			  System.out.println("["+ i +"] Current configuration: "+board1.configString());
    			  
    			  System.out.print("<Type return to continue>");
    			  i++;
    			  in1.nextLine();
    		  }
    		  
    	  }while(!board1.isDone());
    		  
    	  
    	  System.out.println();
    	  System.out.println("Done!");
    	  
      }else {
    	  int i = 1;
    	  System.out.println();
		 while(!board1.isDone()) {
			  board1.playRound();
			  System.out.println("["+ i +"] Current configuration: "+board1.configString());
			  i++;
		 }
		 System.out.println("Done!");
      }
      
  }
   
   // <add private static methods here>
   /* calculate the sum of all the number entered if entered correctly.
    * return the sum, PRE: none.
    * */
   private static int sumList(ArrayList<Integer> list) {
	   int sum = 0;
	   for(int i=0;i<list.size();i++) {
		   sum += list.get(i); 
	   }
	
	   return sum;
   }
  
}
