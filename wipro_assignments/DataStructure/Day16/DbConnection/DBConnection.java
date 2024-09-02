package Day16.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
public static void main(String[] args) {
	try {
		Connection connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "rps@123");
		System.out.println("Connected successfully");
	}
	catch(Exception e) {
		System.out.println("Connection failed");
	}
	}
}
