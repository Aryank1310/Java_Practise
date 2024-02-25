package com.hughes.exercises.Assignments;
/*Based on the i/p,you need to display whther it is integer or float or character or string.
 */

/**
 * @author KIIT
 *
 */

/**
 * @author KIIT
 *
 */

import java.util.Scanner;

/**
 * @author KIIT
 *
 */
public class D2q6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter input:");

		if (scanner.hasNextInt()) { // using hasNext  function for checking whether unput is int float string
									// or character
			int intValue = scanner.nextInt();
			System.out.println("Integer: " + intValue);
		} else if (scanner.hasNextFloat()) {
			float floatValue = scanner.nextFloat();
			System.out.println("Float: " + floatValue);
		} else if (scanner.hasNext()) {
			String inputString = scanner.next();
			if (inputString.length() == 1) {
				char charValue = inputString.charAt(0);
				System.out.println("Character: " + charValue);
			} else {
				System.out.println("String: " + inputString);
			}
		}

		scanner.close();
	}
}