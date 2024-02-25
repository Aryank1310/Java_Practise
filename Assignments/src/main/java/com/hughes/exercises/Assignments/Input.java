package com.hughes.exercises.Assignments;
import java.util.Scanner;
import java.util.Vector;

public class Input {
    public static void main(String[] args) {
        Vector obj = new Vector();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Insert data");
            System.out.println("2. Delete data");
            System.out.println("3. Display data");
            System.out.println("4. Display duplicates");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int a = scanner.nextInt();
                    obj.add(a);
                    System.out.println("Data inserted successfully.");
                    break;

                case 2:
                    if (!obj.isEmpty()) {
                        System.out.print("Enter data to delete: ");
                        int b = scanner.nextInt();
                        obj.removeElement(b);
                        System.out.println("Data deleted successfully.");
                    } else {
                        System.out.println("Vector is empty. No data to delete.");
                    }
                    break;

                case 3:
                    if (!obj.isEmpty()) {
                        System.out.println("Data in the vector: " + obj);
                    } else {
                        System.out.println("Vector is empty. No data to display.");
                    }
                    break;

                case 4:
                    findDuplicates(obj);
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
    }

    private static void findDuplicates(Vector<Integer> obj) {
        Vector duplicates = new Vector<>();
        Vector seen = new Vector<>();

        for (Integer data : obj) {
            if (seen.contains(data) && !duplicates.contains(data)) {
                duplicates.add(data);
            } else {
                seen.add(data);
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate values: " + duplicates);
        }
    }
}
