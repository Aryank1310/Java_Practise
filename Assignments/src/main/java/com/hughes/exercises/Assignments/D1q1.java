package com.hughes.exercises.Assignments;

/* 
 Input string = " aksajd5676@$%^"
 write a program to the:
 No of Numbers:
 No of Alphabets:
 Total Size: 
 */

/**
 * @author KIIT
 *
 */
public class D1q1 {

	public static void main(String[] args) {
		String a = "aksajd5676@$%^";
		int n1 = 0; // no. of numbers
		int n2 = 0; // no. of alphabets
		
		for(char ch : a.toCharArray()) {       //converting the string to charArray for checking
			if(Character.isDigit(ch)) {        // using predefined function for checking
				n1++;
			}else if(Character.isLetter(ch)) {
				n2++;
			}
		}
		System.out.println("No. of numbers: " + n1);
		System.out.println("No. of alphabets: " + n2);
		System.out.println("Total length : " + a.length());
		

	}

}
