// { Driver Code Starts

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.safePos(n,k));
        }
    }
}// } Driver Code Ends



class Solution {
    static int safePos(int n, int k) {
        // code here
        if(n==1)
            return n;
         
        return (safePos(n-1,k)+k-1)%n+1;
    }
};