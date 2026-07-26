import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to write to output.txt: ");
        String content = scanner.nextLine();
        scanner.close();
        Path path = Path.of("output.txt");
        try {
            Files.writeString(path, content + System.lineSeparator());
            System.out.println("Data written to " + path.toAbsolutePath());
        } catch (IOException ex) {
            System.out.println("File writing failed: " + ex.getMessage());
        }
    }
}