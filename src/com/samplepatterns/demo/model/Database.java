package com.samplepatterns.demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static Database instance = new Database();
	private Connection con;

	private Database() {
/*		String dbUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "student";
		String pass = "student";*/
		

	}
	
	public Connection getConnection() {
		return con;
	}

	public static Database getInstance() {
		return instance;
	}
	
	public void connect() throws Exception {
		if (con != null)
			return;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}

		String url = String.format("jdbc:mysql://localhost:3306/demo?useSSL=false");

		con = DriverManager.getConnection(url, "student", "student");
	}
	
	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Can't close connection");
			}
		}
		
		con = null;
	}

}
