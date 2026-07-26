import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionHandlingJdbc {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:accounts.db")) {
                conn.setAutoCommit(false);
                try (Statement st = conn.createStatement()) {
                    st.executeUpdate("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance INTEGER);");
                    st.executeUpdate("INSERT OR IGNORE INTO accounts (id, balance) VALUES (1, 1000), (2, 500);");
                }
                try (PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?;");
                     PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?;")) {
                    debit.setInt(1, 200); debit.setInt(2, 1); debit.executeUpdate();
                    credit.setInt(1, 200); credit.setInt(2, 2); credit.executeUpdate();
                    conn.commit();
                    System.out.println("Transaction committed.");
                } catch (SQLException ex) {
                    conn.rollback();
                    System.out.println("Rolled back due to: " + ex.getMessage());
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("JDBC transaction error: " + ex.getMessage());
        }
    }
}