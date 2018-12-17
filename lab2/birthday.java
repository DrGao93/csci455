import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class birthday {
    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);

	System.out.print("Enter your birth month [1..12]: ");
	int month = in.nextInt();
       
    in.nextLine();

	System.out.print("Enter your birth day of month:");
	int day = in.nextInt();
       
    in.nextLine();   

	System.out.print("Enter your birth year [4-digit year]:");
    int year = in.nextInt();
    
    GregorianCalendar myCalendar = new GregorianCalendar();
    int thisDate = myCalendar.get(Calendar.DAY_OF_MONTH); 
    int thisMonth = myCalendar.get(Calendar.MONTH);   
       int thisYear = myCalendar.get(Calendar.YEAR);   
     int age; 
       
    if(month > thisMonth +1) {
       System.out.println("Your birthday hasn't happened");
       age = thisYear - year - 1;
    }  
     else if (month == thisMonth +1){
        if(day > thisDate){
           System.out.println("Your birthday hasn't happened");
           age = thisYear - year - 1;
        }
        else{
           
           if(day == thisDate){
              System.out.println("Your birthday is today!");
           }
           else{
              System.out.println("Your birthday has happened");
           }
           
           age = thisYear - year;
        }
     }
     else{
        System.out.println("Your birthday has happened");
        age = thisYear - year ;
     }  
       System.out.println("Your age is: "+ age);
    }
}