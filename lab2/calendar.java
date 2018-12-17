import java.util.Calendar;
import java.util.GregorianCalendar;


   
   
public class calendar {

   public static void main(String [] args) {
      
      GregorianCalendar myCalendar = new GregorianCalendar(1995, 0, 20);

      System.out.println("old date: " + myCalendar.get(Calendar.DAY_OF_MONTH));
      
      myCalendar.add(Calendar.DAY_OF_MONTH,20);
      
      System.out.println("date: " + myCalendar.get(Calendar.DAY_OF_MONTH)); 
   } 
}
  

