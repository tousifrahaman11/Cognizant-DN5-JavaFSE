import java.util.Locale;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();
        scanner.close();
        String normalized = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
        String reversed = new StringBuilder(normalized).reverse().toString();
        if (normalized.equals(reversed)) {
            System.out.println("The text is a palindrome.");
        } else {
            System.out.println("The text is not a palindrome.");
        }
    }
}