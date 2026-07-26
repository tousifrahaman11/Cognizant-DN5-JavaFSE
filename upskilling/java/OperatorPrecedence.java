public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        System.out.println("Expression 10 + 5 * 2 = " + result + " (multiplication before addition)");
        System.out.println("Expression (10 + 5) * 2 = " + result2 + " (parentheses change order)");
    }
}