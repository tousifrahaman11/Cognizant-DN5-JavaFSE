import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        System.out.println("Basic JDBC example connecting to students.db (SQLite).");
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db")) {
                try (Statement st = conn.createStatement()) {
                    st.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT);");
                    try (ResultSet rs = st.executeQuery("SELECT * FROM students;")) {
                        while (rs.next()) {
                            System.out.println("Student: " + rs.getInt("id") + " - " + rs.getString("name"));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("JDBC error: " + ex.getMessage());
        }
    }
}