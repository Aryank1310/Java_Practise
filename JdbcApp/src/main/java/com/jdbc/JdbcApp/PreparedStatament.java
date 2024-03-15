package com.jdbc.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatament {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hughes", "root", "Ragnar@13");
			Scanner s = new Scanner(System.in);
		     System.out.println("enter ename");
		     String name = s.nextLine();
		     System.out.println("enter empid");
		     int id = s.nextInt();
			stmt = con.prepareStatement("update employee set ename=?  where empid=?");
			stmt.setString(1,name);
			stmt.setInt(2, id);
			int status = stmt.executeUpdate();
			if (status > 0)
				System.out.println("record updated");
			else
				System.out.println("record not  updated");
			//con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
}