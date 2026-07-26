import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("Banana");
        items.add("Apple");
        items.add("Cherry");
        Collections.sort(items, (a, b) -> a.compareToIgnoreCase(b));
        items.forEach(item -> System.out.println(item));
    }
}