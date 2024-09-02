package Day16.UserAuthorization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthentication {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/your_database_name";
    static final String DB_USER = "your_database_username";
    static final String DB_PASSWORD = "your_database_password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String userIdInput = "testuser"; // Replace with user input
            String passwordInput = "testpassword"; // Replace with user input
            String hashedPasswordInput = PasswordHashing.hashPassword(passwordInput);

            String sql = "SELECT Password FROM User WHERE UserID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userIdInput);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPasswordFromDB = rs.getString("Password");

                if (hashedPasswordFromDB.equals(hashedPasswordInput)) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Incorrect password.");
                }
            } else {
                System.out.println("User not found.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}