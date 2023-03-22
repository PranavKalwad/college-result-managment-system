import java.sql.*;
import java.sql.DriverManager;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class connect_temp {
    public static void main(String[] args) {
        // JDBC driver and database URL
        String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
        String DB_URL = "jdbc:mariadb://localhost:3308/temp";

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
            String sql = "SELECT * FROM student_result";
            rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                String srn = rs.getString("srn");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                byte[] image1 = rs.getBytes("UE20CS351_script");
                byte[] image2 = rs.getBytes("UE20CS352_script");
                byte[] image3 = rs.getBytes("UE20CS353_script");
                byte[] image4 = rs.getBytes("E3_script");
                byte[] image5 = rs.getBytes("E4_script");

                System.out.println(srn);
                System.out.println(name);
                System.out.println(marks);

                System.out.println(image1);
                System.out.println(image2);
                System.out.println(image3);
                System.out.println(image4);
                System.out.println(image5);

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
