// Name: Jianan Gao   
// USC NetID: 7450905127
// CS 455 PA1
// Fall 2018

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
import java.util.Random;


public class CoinTossSimulator {

   int numRuns;
   int numTwoHeads;
   int numHeadTails;
   int numTwoTails;
   
   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      numTwoHeads = 0;
      numTwoTails = 0;
      numHeadTails = 0;
      numRuns = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      numRuns += numTrials;
      Random rand = new Random();
      int result = 0;
       for(int i=0;i<numTrials;i++){
          result += rand.nextInt(2);
          result += rand.nextInt(2);
          if(result == 0){
             numTwoHeads ++;
          }
          if(result == 1){
             numHeadTails ++;
          }
          if(result == 2){
             numTwoTails ++;
          }
          result = 0;
       }
      
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return numRuns; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return numTwoHeads;
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return numTwoTails; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return numHeadTails; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      numTwoHeads = 0;
      numTwoTails = 0;
      numHeadTails = 0;
      numRuns = 0;
   }

}
