import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int target = 1 + (int) (Math.random() * 100);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the number between 1 and 100.");
        while (true) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            if (guess < target) {
                System.out.println("Too low.");
            } else if (guess > target) {
                System.out.println("Too high.");
            } else {
                System.out.println("Correct! The number was " + target + ".");
                break;
            }
        }
        scanner.close();
    }
}