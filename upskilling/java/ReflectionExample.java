import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("java.lang.String");
            Method[] methods = c.getDeclaredMethods();
            System.out.println("Methods in String: ");
            for (Method m : methods) System.out.println(m.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}