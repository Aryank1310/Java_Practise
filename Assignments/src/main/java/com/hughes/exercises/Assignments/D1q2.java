package com.hughes.exercises.Assignments;

/*
 write a java program for below requirement.
i/p:Hydrabad
o/p:dabardyH
 */



/**
 * @author KIIT
 *
 */
public class D1q2 {

	public static void main(String[] args) {
		String a = "Hydrabad"; 
		char[] charArray = a.toCharArray();         // storing the string in charArray
		for(int i = 0; i<a.length()/2;i++){         // loop to swap the characters from starting and ending
			char temp = charArray[i];
			charArray[i] = charArray[a.length() - i - 1];
			charArray[a.length() - i - 1] = temp;
			
		}
		String r = new String(charArray);
		System.out.print("The output = " + r);
				

	}

}
