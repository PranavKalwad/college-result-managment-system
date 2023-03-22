import java.sql.*;
import java.sql.DriverManager;


public class connect_main {
    public static void main(String[] args) {
        // JDBC driver and database URL
        String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
        String DB_URL = "jdbc:mariadb://localhost:3308/main";

        // Database credentials
        String USER = "root";
        String PASS = "123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM results";
            rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                String srn = rs.getString("srn");
                String name = rs.getString("student_name");
                String UE20CS351_grade = rs.getString("UE20CS351_grade");
                String UE20CS352_grade = rs.getString("UE20CS352_grade");
                String UE20CS353_grade = rs.getString("UE20CS353_grade");
                String E3_grade = rs.getString("E3_grade");
                String E4_grade = rs.getString("E4_grade");
                double sgpa = rs.getDouble("sgpa");

                System.out.println(srn);
                System.out.println(name);
                System.out.println(UE20CS351_grade);
                System.out.println(UE20CS352_grade);
                System.out.println(UE20CS353_grade);
                System.out.println(E3_grade);
                System.out.println(E4_grade);
                System.out.println(sgpa);

                // Do something with the data...
            }

            // Clean up resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Make sure resources are closed even if an exception occurs
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
