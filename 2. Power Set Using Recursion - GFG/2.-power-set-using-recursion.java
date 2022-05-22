// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //testcases        
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //input string
            String st = sc.next();
            
            //calling powerSet() function
            ArrayList<String> ans = new LexSort().powerSet(st);
            
            //sorting the result of the powerSet() function
            Collections.sort(ans);
    
            //printing the result
            for(String s: ans)
                System.out.print(s + " ");
            System.out.println();    
        }
    }
}


 // } Driver Code Ends
//User function Template for Java


class LexSort
{
    //Function to return the lexicographically sorted power-set of the string.
    static ArrayList<String> powerSet(String s)
    {
        // add your code here
        ArrayList<String> ans = new ArrayList<>();
        helper(ans, s, 0, "");
        return ans;
    }
    
    static void helper(ArrayList<String> ans, String s, int i, String op) {
        if(i==s.length()) {
            ans.add(op);
            return;
        }
        helper(ans, s, i+1, op);
        helper(ans, s, i+1, op+s.charAt(i));
    }
}


 

// { Driver Code Starts.

                                // } Driver Code Ends