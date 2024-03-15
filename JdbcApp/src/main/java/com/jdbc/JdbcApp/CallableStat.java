package com.jdbc.JdbcApp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class CallableStat {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hughes", "root", "Ragnar@13");
			stmt = con.prepareCall("{call proc1(?,?)}");
			stmt.setInt(1, 101);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

			boolean status = stmt.execute();
			System.out.println(stmt.getString(2));
			// System.out.println(stmt.getInt(1) + " " + stmt.getString(2) + " " +
			// stmt.getInt(3));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
}
