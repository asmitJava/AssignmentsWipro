package Day16.PreparedStatement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatement {
    public static void main(String[] args) {
     
      
    

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
            return;
        }

        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "rps@123")) {
            System.out.println("Connected to the database");

            
            String query = "SELECT * FROM student1 WHERE student_name = ? AND student_id > ?";
            try (java.sql.PreparedStatement pstmt = connection.prepareStatement(query)) {
                
                pstmt.setString(1, "Jiraya");
                pstmt.setInt(2, 111); 

                // Execute the query
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    System.out.println("Query executed successfully");

                    
                    while (resultSet.next()) {
                        int id = resultSet.getInt("student_id");
                        String name = resultSet.getString("student_name");
                        
                        

                        System.out.println("ID: " + id + ", Name: " + name);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}