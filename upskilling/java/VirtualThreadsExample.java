
public class VirtualThreadsExample {

    public static void main(String[] args) {
        System.out.println("Virtual threads require Java 21+.");
        try {
            try {
                java.lang.reflect.Method m = Thread.class.getMethod("startVirtualThread", Runnable.class);
                m.invoke(null, (Runnable) () -> System.out.println("Hello from virtual thread"));
            } catch (NoSuchMethodException nsme) {
                // Fallback for older JDKs
                System.out.println("Virtual threads not available; using platform thread.");
                new Thread(() -> System.out.println("Hello from platform thread")).start();
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("Error starting virtual thread: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
