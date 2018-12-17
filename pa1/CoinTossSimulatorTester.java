/*tester for coinTossSimulator*/

import java.util.Scanner;
public class CoinTossSimulatorTester {
   /*main program to give test cases*/
   public static void main(String[] args){
      

      CoinTossSimulator sim0 = new CoinTossSimulator();
      sim0.run(0);
      System.out.println("After constructor:");
      System.out.println("Number of trials [exp:0]: 0");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
      
      System.out.println();
      
      sim0.run(1);
      System.out.println("After run(1):");
      System.out.println("Number of trials [exp:1]: 1");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
  
      System.out.println();
      
      sim0.run(10);
      System.out.println("After runn(10)");
      System.out.println("Number of trials [exp:10]: 11");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
  
      System.out.println();
      
      sim0.run(100);
      System.out.println("After runn(100)");
      System.out.println("Number of trials [exp:100]: 111");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
  
      System.out.println();
      
      sim0.run(200);
      System.out.println("After runn(200)");
      System.out.println("Number of trials [exp:200]: 311");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
  
      System.out.println();
      
      sim0.run(300);
      System.out.println("After runn(300)");
      System.out.println("Number of trials [exp:300]: 611");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
      
      System.out.println();
      
      sim0.reset();
      System.out.println("After reset");
      System.out.println("Number of trials [exp:0]: 0");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
      
      System.out.println();
      
      sim0.run(1000);
      System.out.println("After runn(1000)");
      System.out.println("Number of trials [exp:1000]: 1000");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
      
      System.out.println();
      
      sim0.run(2000);
      System.out.println("After runn(2000)");
      System.out.println("Number of trials [exp:2000]: 3000");
      System.out.println("Two-head tosses: "+sim0.getTwoHeads());
      System.out.println("Two-tail tosses: "+sim0.getTwoTails());
      System.out.println("One-head one-tail tosses: "+sim0.getHeadTails());
      System.out.println("Tosses add up correctly? "+ (sim0.getNumTrials() == sim0.getTwoHeads() +             sim0.getTwoTails()+sim0.getHeadTails()));
   }
}
