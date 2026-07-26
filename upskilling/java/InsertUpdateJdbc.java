import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUpdateJdbc {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db")) {
                try (PreparedStatement ins = conn.prepareStatement("INSERT INTO students (name) VALUES (?);")) {
                    ins.setString(1, "New Student");
                    ins.executeUpdate();
                }
                try (PreparedStatement upd = conn.prepareStatement("UPDATE students SET name = ? WHERE id = ?;")) {
                    upd.setString(1, "Updated Student");
                    upd.setInt(2, 1);
                    upd.executeUpdate();
                }
                System.out.println("Insert/update executed.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("JDBC error: " + ex.getMessage());
        }
    }
}