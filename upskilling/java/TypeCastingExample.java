public class TypeCastingExample {
    public static void main(String[] args) {
        double originalDouble = 12.78;
        int castToInt = (int) originalDouble;
        int originalInt = 7;
        double castToDouble = originalInt;
        System.out.println("Original double: " + originalDouble);
        System.out.println("After casting to int: " + castToInt);
        System.out.println("Original int: " + originalInt);
        System.out.println("After casting to double: " + castToDouble);
    }
}