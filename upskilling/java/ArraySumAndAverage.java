import java.util.Scanner;

public class ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int count = scanner.nextInt();
        if (count <= 0) {
            System.out.println("Element count must be positive.");
            scanner.close();
            return;
        }
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        int sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        double average = sum / (double) count;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}