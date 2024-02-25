/**
 * 
 */
package com.hughes.exercises.Assignments;

/**
 Program to find duplicate numbers in an array if it contains multiple duplicates? 
 */
/**
 * @author KIIT
 *
 */
import java.util.Arrays;

public class D4q2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2, 5, 6, 3, 7, 8, 9, 1, 9};
        findDuplicates(array);
    }

    public static void findDuplicates(int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // Iterate through the sorted array to find duplicates
        System.out.println("Duplicate  are:");
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                System.out.println(arr[i]);
            }
        }
    }
}

