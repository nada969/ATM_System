import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresConnect {


    public void connect() {
        String url = "jdbc:postgresql://localhost:5432/ATM System";
        String user = "postgres";                                    // PostgreSQL username
        String password = "493075273";                               // PostgreSQL password

        try {
            // Connect to PostgreSQL
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL successfully!");

            // Create statement and query table
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clients_db");
//            ResultSet rs = stmt.executeQuery("SELECT " +{$balance} + " FROM clients_db where" + {CardHolderName} + "=" + );

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("CardHolderName") + " | " +
                        rs.getBigDecimal("balance"));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("exceptionnnnnnnnnn");
        }

    }
}