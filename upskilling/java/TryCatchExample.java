import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();
        try {
            int quotient = dividend / divisor;
            System.out.println("Result: " + quotient);
        } catch (ArithmeticException ex) {
            System.out.println("Cannot divide by zero. " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}