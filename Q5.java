package String_Functions1;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
import java.util.Map.Entry;
import java.util.Scanner;
public class Q5 {
	 public static String removeWhitespace(String str) {
	        // \s matches all whitespace characters (space, tab, newline, etc.)
	        return str.replaceAll("\\s", "");
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String input = sc.nextLine();

	        String result = removeWhitespace(input);

	        System.out.println("String after removing whitespace: " + result);

	        sc.close();
	    }
	}