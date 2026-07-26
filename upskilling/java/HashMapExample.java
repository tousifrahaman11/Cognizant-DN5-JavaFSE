import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add student ID and name pairs (enter 0 to stop ID entry)");
        while (true) {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id == 0) break;
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            studentMap.put(id, name);
        }
        System.out.print("Enter ID to retrieve: ");
        int queryId = Integer.parseInt(scanner.nextLine().trim());
        scanner.close();
        if (studentMap.containsKey(queryId)) {
            System.out.println("Student name: " + studentMap.get(queryId));
        } else {
            System.out.println("No student found with ID " + queryId);
        }
    }
}