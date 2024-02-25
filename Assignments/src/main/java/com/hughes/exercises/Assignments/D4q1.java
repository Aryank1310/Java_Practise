/**
 * 
 */
package com.hughes.exercises.Assignments;
/**
 * Write a Java program to remove duplicate elements from a given array and return the updated array length.
Sample array: [20, 20, 30, 40, 50, 50, 50]
After removing the duplicate elements the program should return 4 as the new length of the array.
 */
/**
 * @author KIIT
 *
 */
import java.util.Arrays;

public class D4q1 {
    public static void main(String[] args) {
        int[] arr = {20, 20, 30, 40, 50, 50, 50};

        int newLen = removeDuplicates(arr);

        System.out.println("New length of the array: " + newLen);
    }

    private static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        // Sort the array to group duplicate elements together
        Arrays.sort(arr);

        int a = 1; // Index to track the unique elements in the updated array

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[a] = arr[i];
                a++;
            }
        }

        return a;
    }
}
