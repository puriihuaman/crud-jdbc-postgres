package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DB_USERNAME = System.getenv("POSTGRES_USER");
	private static final String DB_PASSWORD = System.getenv("POSTGRES_PASSWORD");
	private static final String DB_NAME = "crud_jdbc_postgres";
	private static final String
		DB_URL
		=
		("jdbc:postgresql://localhost:5432/%s?serveTimezone=UTC").formatted(DB_NAME);

	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(DB_URL,
				DB_USERNAME,
				DB_PASSWORD
			);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
