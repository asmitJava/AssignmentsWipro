package com.dsa.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	private static DatabaseManager instance;
	private Connection connection;

	private DatabaseManager() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "rps@123");

		System.out.println("Database connection initialized");
	}

	public static DatabaseManager getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new DatabaseManager();
		}
		return instance;
	}

	public void executeQuery(String query) {
		System.out.println("Executing query: " + query);
	}

	public void closeConnection() {
		System.out.println("Database connection closed");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DatabaseManager dbManager = DatabaseManager.getInstance();
		dbManager.executeQuery("SELECT * FROM users");
		dbManager.executeQuery("UPDATE users SET status = 'active' WHERE id = 1");
		dbManager.closeConnection();
	}
}