package com.jdbc.Abcd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AbcdBank {
	static final String DB_URL = "jdbc:mysql://localhost:3306/hughes";
	static final String USER = "root";
	static final String PASSWORD = "Ragnar@13";

	public static void main(String[] args) {
		Connection con = null;
		//PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			Scanner scanner = new Scanner(System.in);

			while (true) {
	            System.out.println("\nAbcd Bank Application");
	            System.out.println("1. Open New Account");
	            System.out.println("2. Modify Personal Details");
	            System.out.println("3. Display Account Info");
	            System.out.println("4. Delete Account");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					openNewAccount(con, scanner);
					break;
				case 2:
					modifyPersonalDetails(con, scanner);
					break;
				case 3:
					displayAccountInfo(con, scanner);
					break;
				case 4:
                    deleteAccount(con, scanner);
                    break;
                case 5:
                    System.out.println("Exiting Abcd Bank Application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void openNewAccount(Connection con, Scanner scanner) {
		 PreparedStatement stmt = null;
		try {
			System.out.println("\nOpening New Account");

			System.out.print("Enter Name: ");
			String name = scanner.next();

			System.out.print("Enter Aadhar Number: ");
			String aadharNo = scanner.next();

			System.out.print("Enter Age: ");
			int age = scanner.nextInt();

			System.out.print("Enter Balance: ");
			double balance = scanner.nextDouble();

			// Validate balance
			if (balance < 100) {
				System.out.println("Less balance. Minimum balance required is 100.");
				return;
			}

			// Get current date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(new Date());

			// Insert data into the bank table
			String insertQuery = "INSERT INTO bank (acccNo,name, aadharno, age, balance, date) VALUES (?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(insertQuery);
			stmt.setString(1, name);
			stmt.setString(2, aadharNo);
			stmt.setInt(3, age);
			stmt.setDouble(4, balance);
			stmt.setString(5, date);

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Account opened successfully!");
			} else {
				System.out.println("Failed to open account. Please try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 private static void deleteAccount(Connection con, Scanner scanner) {
	        PreparedStatement stmt = null;
	        try {
	            System.out.println("\nDeleting Account");

	            System.out.print("Enter Account Number: ");
	            int accountNo = scanner.nextInt();

	            // Retrieve opening date to check if it's within 60 days
	            String selectDateQuery = "SELECT date FROM bank WHERE accNo = ?";
	            stmt = con.prepareStatement(selectDateQuery);
	            stmt.setInt(1, accountNo);

	            ResultSet dateResultSet = stmt.executeQuery();
                 //Checks if there is at least one row in the result set. If true, it means the account exists.
	            if (dateResultSet.next()) {
	                String openingDateStr = dateResultSet.getString("date");
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                Date openingDate = sdf.parse(openingDateStr);
	                Date currentDate = new Date();

	                // Calculate the difference in days
	                long differenceInDays = (currentDate.getTime() - openingDate.getTime()) / (24 * 60 * 60 * 1000);

	                if (differenceInDays <= 60) {
	                    System.out.println("You are not allowed to close the account within 60 days of opening.");
	                    return;
	                }
	            }

	            // Delete account from the bank table
	            String deleteQuery = "DELETE FROM bank WHERE accNo = ?";
	            stmt = con.prepareStatement(deleteQuery);
	            stmt.setInt(1, accountNo);

	            int rowsAffected = stmt.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Account deleted successfully!");
	            } else {
	                System.out.println("Failed to delete account. Please check the account number.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	

	private static void modifyPersonalDetails(Connection con, Scanner scanner) {
		 PreparedStatement stmt = null;
		try {
			System.out.println("\nModifying Personal Details");

			System.out.print("Enter Account Number: ");
			int accountNo = scanner.nextInt();

			System.out.print("Enter New Name: ");
			String newName = scanner.next();

			// Update data in the bank table
			String updateQuery = "UPDATE bank SET name = ? WHERE accNo = ?";
			stmt = con.prepareStatement(updateQuery);
			stmt.setString(1, newName);
			stmt.setInt(2, accountNo);

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Personal details updated successfully!");
			} else {
				System.out.println("Failed to update personal details. Please check the account number.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void displayAccountInfo(Connection con, Scanner scanner) {
		 PreparedStatement stmt = null;
		try {
			System.out.println("\nDisplaying Account Info");

			System.out.print("Enter Account Number: ");
			int accountNo = scanner.nextInt();

			// Retrieve data from the bank table
			String selectQuery = "SELECT * FROM bank WHERE accNo = ?";
			stmt = con.prepareStatement(selectQuery);
			stmt.setInt(1, accountNo);

			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				System.out.println("Account Information:");
				System.out.println("Account Number: " + resultSet.getInt("accNo"));
				System.out.println("Name: " + resultSet.getString("name"));
				System.out.println("Aadhar Number: " + resultSet.getString("aadharno"));
				System.out.println("Age: " + resultSet.getInt("age"));
				System.out.println("Balance: " + resultSet.getDouble("balance"));
				System.out.println("Opening Date: " + resultSet.getString("date"));
			} else {
				System.out.println("Account not found. Please check the account number.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

