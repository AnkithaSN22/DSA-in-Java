package nptel;
import java.util.*;

public class even_odd {
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	System.out.println("enter a number");
	int number = in.nextInt();
	if(number%2==0)
	{
	  System.out.println("Even");
	}
	else
	{
	   System.out.println("Odd");
	}
	in.close();
	    }
}
