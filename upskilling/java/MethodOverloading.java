public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println("Sum of two integers: " + add(5, 7));
        System.out.println("Sum of two doubles: " + add(3.2, 4.8));
        System.out.println("Sum of three integers: " + add(2, 4, 6));
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static int add(int a, int b, int c) {
        return a + b + c;
    }
}