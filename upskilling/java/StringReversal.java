import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();
        scanner.close();
        StringBuilder builder = new StringBuilder(input);
        System.out.println("Reversed string: " + builder.reverse());
    }
}