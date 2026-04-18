package String_Functions1;
import java.util.Scanner;

public class Q7{

    // User-defined function
    public static String truncate(String str, int maxLength) {
        if (str == null) {
            return null;
        }

        // If string length is within limit, return as it is
        if (str.length() <= maxLength) {
            return str;
        }

        // Otherwise, truncate and add ellipsis
        return str.substring(0, maxLength) + "...";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.print("Enter maximum length: ");
        int length = sc.nextInt();

        String result = truncate(input, length);

        System.out.println("Truncated string: " + result);

        sc.close();
    }
}
