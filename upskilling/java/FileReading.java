import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReading {
    public static void main(String[] args) {
        Path path = Path.of("output.txt");
        if (!Files.exists(path)) {
            System.out.println("output.txt does not exist. Run FileWriting first.");
            return;
        }
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println("Contents of output.txt:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("File reading failed: " + ex.getMessage());
        }
    }
}