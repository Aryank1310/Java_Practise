package com.jdbc.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class Aadhar {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hughes", "root", "Ragnar@13");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection succesfully");
		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from aadhar");
			while (rs.next())
				System.out.println(rs.getLong(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getLong(4) + " " + rs.getString(5) + " " + rs.getString(5) + " " + rs.getLong(6));

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
