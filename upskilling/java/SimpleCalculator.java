import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Choose an operation (+, -, *, /): ");
        String op = scanner.nextLine().trim();
        double result;
        switch (op) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> {
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                    scanner.close();
                    return;
                }
                result = a / b;
            }
            default -> {
                System.out.println("Unknown operation.");
                scanner.close();
                return;
            }
        }
        System.out.println("Result: " + result);
        scanner.close();
    }
}