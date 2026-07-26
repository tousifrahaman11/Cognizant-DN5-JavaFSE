public class ThreadCreation {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MessagePrinter("Thread-1"));
        Thread t2 = new Thread(new MessagePrinter("Thread-2"));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static class MessagePrinter implements Runnable {
        private final String name;
        MessagePrinter(String name) { this.name = name; }
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(name + " prints message " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        }
    }
}