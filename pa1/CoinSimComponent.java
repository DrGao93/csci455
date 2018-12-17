import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class CoinSimComponent extends JComponent {
	
	static final int barWidth = 75;
	static final int verticalBuffer = 40;
	
	private int numTwoHeads;
	private int numTwoTails;
	private int numHeadTails;
	
	public CoinSimComponent(int numTwoHeads,int numHeadTails,int numTwoTails){
		this.numTwoHeads = numTwoHeads;
		this.numHeadTails = numHeadTails;
		this.numTwoTails = numTwoTails;
	}	
	public void paintComponent(Graphics g)
	   {  
		  
	      Graphics2D g2 = (Graphics2D) g;
	      int width = (getWidth()- barWidth*3)/4;
	      double scale = (double) ( (double) (getHeight() - verticalBuffer*2)/(numTwoHeads+numHeadTails+numTwoTails));
	      String strTwoHeads = "Two Heads: "+ numTwoHeads + " ("+Math.round((double) numTwoHeads*100/(double) (numTwoHeads+numHeadTails+numTwoTails)) +"%)";
	      Bar barTwoHeads = new Bar(getHeight()-verticalBuffer,width,barWidth,numTwoHeads,scale,Color.RED,strTwoHeads);
	      
	      String strHeadTails = "A head and tail:"+ numHeadTails + "("+ Math.round((double) numHeadTails*100/(double) (numTwoHeads+numHeadTails+numTwoTails)) +"%)";
	      Bar barHeadTails = new Bar(getHeight()-verticalBuffer,width*2+barWidth,barWidth,numHeadTails,scale,Color.green,strHeadTails);
	      
	      String strTwoTails = "Two Tails: "+ numTwoTails + " ("+ Math.round((double) numTwoTails*100/(double) (numTwoHeads+numHeadTails+numTwoTails)) +"%)";
	      Bar barTwoTails = new Bar(getHeight()-verticalBuffer,width*3+barWidth*2,barWidth,numTwoTails,scale,Color.blue,strTwoTails);
	      
	      
	      
	      
	      barTwoHeads.draw(g2);
	      barHeadTails.draw(g2);
	      barTwoTails.draw(g2);
	      
	   }
	
	
}
