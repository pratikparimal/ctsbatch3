package com.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDB {

	private static Connection con;

	public static void main(String[] args) {

		try {
			// 1. Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Create a connection
			con = DriverManager.getConnection("jdbc:mysql://localhost/ctsbatch3db?user=root&password=root");
			System.out.println("Connected to the DB!!");
			insertEmp("CTS0022", "Ravi", "Pune", 34433);
			// 5. Close connection	
			con.close();
			System.out.println("Disconnected!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertEmp(String code, String name, String city, int sal) {
		try {
			// 3. Create a statement (SQL query)
			PreparedStatement ps = con.prepareStatement("insert into Emp values(?,?,?,?)");
			ps.setString(1, code);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setInt(4, sal);
			// 4. Fire the query
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("not Inserted");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

}
