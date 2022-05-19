package Recursion;

import java.util.Scanner;

/**
 * Question: Remove all occurrences of 'x' character in a string. Consider string to be in lowercase.
 * Example: simxxrxxxxanx -> simran
 */
public class RemoveX {

    private String removeX(String str) {
        if(str.isEmpty()) return str;
        String ans = "";

        if (str.charAt(0)!='x') ans+=str.charAt(0);

        String smallAns = removeX(str.substring(1));

        return ans+smallAns;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        RemoveX obj = new RemoveX();
        System.out.println(obj.removeX(str));
    }
}
