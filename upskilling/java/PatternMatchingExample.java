import java.util.Scanner;

public class PatternMatchingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value: ");
        String input = scanner.nextLine();
        scanner.close();
        Object value = parse(input);
        if (value instanceof Integer) {
            System.out.println("Integer: " + value);
        } else if (value instanceof Double) {
            System.out.println("Double: " + value);
        } else if (value instanceof String) {
            System.out.println("String: " + value);
        } else {
            System.out.println("Unknown type: " + value.getClass().getSimpleName());
        }
    }

    private static Object parse(String s) {
        try { return Integer.parseInt(s); } catch (NumberFormatException ignored) {}
        try { return Double.parseDouble(s); } catch (NumberFormatException ignored) {}
        return s;
    }
}