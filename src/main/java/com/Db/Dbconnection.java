
package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
	private static Connection Conn;

	public static Connection getconn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "root123@");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return Conn;

	}

}
