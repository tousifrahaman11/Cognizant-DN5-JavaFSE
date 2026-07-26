import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Callable<String> t1 = () -> "Result from callable 1";
        Callable<String> t2 = () -> "Result from callable 2";
        try {
            List<Future<String>> futures = service.invokeAll(List.of(t1, t2));
            for (Future<String> f : futures) {
                System.out.println(f.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Executor error: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            service.shutdown();
        }
    }
}