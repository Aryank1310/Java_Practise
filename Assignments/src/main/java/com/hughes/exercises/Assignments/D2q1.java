package com.hughes.exercises.Assignments;


/*i/p: a b c d e f
o/p: f1 e2 d3 c4 b5 a6

*/

/**
 * @author KIIT
 *
 */
public class D2q1 {

	public static void main(String[] args) {
		String a = "a b c d e f";
		String[] z = a.split(" ");  // reversing the array
		for(int i = 0; i < z.length / 2;i++) {
			String temp = z[i];
			z[i] = z[z.length-1-i];
			z[z.length-1-i] = temp;
		}
		
		for(int i = 0; i < z.length;i++) {      //printing the reversed elements
			System.out.println(z[i] + (i + 1));
			if( i < z.length - 1) {
				System.out.println(" ");
			}
		}

	}

}
