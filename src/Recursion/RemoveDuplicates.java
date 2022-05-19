package Recursion;

import java.util.Scanner;

/**
 * Question: Remove consecutive duplicate characters from a string. Consider string to be in lowercase.
 * Example : aakaash -> akash
*/
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        System.out.println(removeConsecutiveDuplicates(str));

    }

    static String removeConsecutiveDuplicates(String str) {
        if(str.length() <= 1) return str;

        if(str.charAt(0)==str.charAt(1)) {
            return removeConsecutiveDuplicates(str.substring(1));
        } else {
            char ans = str.charAt(0);
            String nextAns = removeConsecutiveDuplicates(str.substring(1));
            return ans+nextAns;
        }
    }
}
