package String_Functions1;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class Q3 {

	 public static String reverseString(String str) {
	        String reversed = "";

	        for (int i = str.length() - 1; i >= 0; i--) {
	            reversed += str.charAt(i);
	        }

	        return reversed;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String input = sc.nextLine();

	        String result = reverseString(input);

	        System.out.println("Reversed string: " + result);

	        sc.close();
	    }
	}








