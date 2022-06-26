package Recursion;

public class isPowerOf2 {
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n==1) return true;
            if(n%2 != 0) return false;
            if(n==2) return true;
            return isPowerOfTwo(n/2);
        }
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.isPowerOfTwo(16));
    }
}


