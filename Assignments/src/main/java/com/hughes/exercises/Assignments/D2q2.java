package com.hughes.exercises.Assignments;
/*
 i/p = 34567
 o/p = Thirty Four Thousand Five Hundred Sixty Seven 
 */

/**
 * @author KIIT
 *
 */
public class D2q2 {

    private static final String[]  x= new String[] {             // array that dircetly correspond to numeric value
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] y= new String[] {
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static void main(String[] args) {
        int a = 34567;
        String words = convert(a);
        System.out.println("i/p: " + a);
        System.out.println("o/p: " + words);
    }

    public static String convert(int num) {
        if (num == 0)
            return "Zero";

        return helper(num);
    }

    private static String helper(int num) {                  //helper function for converting
        String ans = "";
        if (num < 20)
            ans = x[num];
        else if (num < 100)
            ans = y[num / 10] + " " + helper(num % 10);
        else if (num < 1000)
            ans = helper(num / 100) + " Hundred " + helper(num % 100);
        else if (num < 1000000)
            ans = helper(num / 1000) + " Thousand " + helper(num % 1000);
        else  
            ans = helper(num / 1000000) + " Lakh " + helper(num % 1000000);
       

        return ans;
    }
}
