package String_Functions1;
//Java Program to generate a random string of given length
import java.util.Random;
import java.util.Scanner;

public class Q9 {

 // User-defined function to generate random string
 public static String generateRandomString(int length) {
     String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
     StringBuilder randomString = new StringBuilder();
     Random random = new Random();

     for (int i = 0; i < length; i++) {
         int index = random.nextInt(characters.length());
         randomString.append(characters.charAt(index));
     }

     return randomString.toString();
 }

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.print("Enter the length of the random string: ");
     int length = sc.nextInt();

     String result = generateRandomString(length);

     System.out.println("Random String: " + result);

     sc.close();
 }
}