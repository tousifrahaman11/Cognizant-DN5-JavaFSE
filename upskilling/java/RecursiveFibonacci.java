import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer for Fibonacci: ");
        int n = scanner.nextInt();
        scanner.close();
        if (n < 1) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        System.out.println("Fibonacci number " + n + " = " + fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}