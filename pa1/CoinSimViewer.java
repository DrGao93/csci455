import javax.swing.JFrame;
import java.util.Scanner;


public class CoinSimViewer {
	public static void main(String[] args)
	   {
	      JFrame frame = new JFrame();

	      frame.setSize(800, 500);
	      frame.setTitle("CoinSim");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      Scanner in = new Scanner(System.in);
	      System.out.print("Enter number of trials: ");
	      int numTrials = in.nextInt();
	      while(numTrials <=0) {
	    	  System.out.println("ERROR: Number entered must be greater than 0.");
	    	  System.out.print("Enter number of trials: ");
	    	  numTrials = in.nextInt();
	      }
	     
	      
	      CoinTossSimulator sim0 = new CoinTossSimulator();
	      sim0.run(numTrials);

	      
	      CoinSimComponent component = new CoinSimComponent(sim0.getTwoHeads(),sim0.getHeadTails(),sim0.getTwoTails());
	      //CoinSimComponent component = new CoinSimComponent(100,0,0);
	      frame.add(component);

	      frame.setVisible(true);
	   }
}
