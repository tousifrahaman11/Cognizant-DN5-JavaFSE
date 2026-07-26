import java.util.Scanner;

public class EvenOrOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int value = scanner.nextInt();
        if (value % 2 == 0) {
            System.out.println(value + " is even.");
        } else {
            System.out.println(value + " is odd.");
        }
        scanner.close();
    }
}