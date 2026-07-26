import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter names (empty line to finish):");
        while (true) {
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                break;
            }
            names.add(name);
        }
        scanner.close();
        System.out.println("Names entered:");
        names.forEach(System.out::println);
    }
}