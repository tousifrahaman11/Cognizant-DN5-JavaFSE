import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.close();
        try {
            checkAge(age);
            System.out.println("Age is valid.");
        } catch (InvalidAgeException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
    }
}

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}