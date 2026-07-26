import java.util.List;

public class RecordsExample {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Alice",25), new Person("Bob",17));
        people.forEach(System.out::println);
    }
}

record Person(String name, int age) {}