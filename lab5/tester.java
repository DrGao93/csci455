
import java.util.ArrayList;
import java.util.Scanner;

public class tester{
   public static void main(String[] argvs){
      
      
      while(true){
         Scanner in1 = new  Scanner(System.in);
         ArrayList<Integer> array =new ArrayList<Integer>();
         System.out.print("Enter a space separated list of numbers: ");
         String string = in1.nextLine();
         Scanner in2 = new  Scanner(string);
         while(in2.hasNextInt()){
            
            array.add(in2.nextInt());
            //System.out.println("here");
         }
           
         System.out.println();
         System.out.println(array);
         
      
      }
   
   }
}