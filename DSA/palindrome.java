package dsa_java25;
import java.util.*;
public class palindrome {
	    public static void main(String args[]) {
	        int numb;
	        palindrome obj = new palindrome(); 
	        Scanner sn = new Scanner(System.in);

	        System.out.println("Enter a number:");
	        numb = sn.nextInt();

	        if (obj.isPalindrome(numb)) {
	            System.out.println("The given number " + numb + " is a palindrome.");
	        } else {
	            System.out.println("The given number " + numb + " is not a palindrome.");
	        }

	        sn.close(); 
	    }
	    public boolean isPalindrome(int x) {
	        if (x < 0) {
	            return false; 
	        }

	        int rv = 0, temp = x;
	        while (temp > 0) {
	            int digit = temp % 10;
	            rv = rv * 10 + digit;
	            temp /= 10;
	        }

	        return rv == x; 
	    }
	}
