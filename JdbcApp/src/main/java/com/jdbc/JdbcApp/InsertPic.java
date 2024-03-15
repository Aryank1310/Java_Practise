package com.jdbc.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;
import java.io.FileInputStream;  


/**
 * Hello world!
 *
 */
public class InsertPic {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hughes", "root", "Ragnar@13");
			  Scanner s = new Scanner(System.in);
		     
			stmt = con.prepareStatement("insert into profile value(?,?)");
			stmt.setString(1,"Thread");
			FileInputStream fs = new FileInputStream("C:\\profile\\hangman0.png");
			stmt.setBinaryStream(2, fs);
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