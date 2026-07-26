import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 9000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connected to server. Type messages (type 'quit' to exit)");
            String line;
            while ((line = stdin.readLine()) != null) {
                out.println(line);
                System.out.println("Server replied: " + in.readLine());
                if ("quit".equalsIgnoreCase(line.trim())) break;
            }
        }
    }
}