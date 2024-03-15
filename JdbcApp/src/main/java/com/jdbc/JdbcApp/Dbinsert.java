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
public class Dbinsert {
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
			/*
			 * int status = stmt.
			 * executeUpdate("insert into employee(empid,ename,age) values(106,'edu',45)");
			 * if(status > 0) System.out.println("record enetered"); else
			 * System.out.println("record not  enetered");
			 */
			/*
			 * int status =
			 * stmt.executeUpdate("update employee set ename = 'srinivas' where empid = 100"
			 * ); if(status > 0) System.out.println("record updated"); else
			 * System.out.println("record not  updated");
			 */
			int status = stmt.executeUpdate("delete  from  employee where empid = 102");
			if (status > 0)
				System.out.println("deleted");
			else
				System.out.println("not  deleted");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
