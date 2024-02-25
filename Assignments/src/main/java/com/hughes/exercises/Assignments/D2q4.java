package com.hughes.exercises.Assignments;
/* i/p:String a = "Computer"
o/p: r e t u p m o C
 */

/**
 * @author KIIT
 *
 */
public class D2q4 {

	public static void main(String[] args) {
		String a = "Computer";
		char[] z = a.toCharArray(); // storing the string in charArray
		for (int i = 0; i < a.length() / 2; i++) { // loop to swap the characters from starting and ending
			char temp = z[i];
			z[i] = z[a.length() - i - 1];
			z[a.length() - i - 1] = temp;

		}
			
		for(int i = 0; i < z.length;i++) {      //printing the reversed elements
			System.out.print(z[i]);
			if( i < z.length - 1) {
				System.out.print(" ");
			}
		}
	}
}
