package Recursion;

import java.util.Scanner;

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
