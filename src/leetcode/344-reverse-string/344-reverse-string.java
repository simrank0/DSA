class Solution {
    public void reverseString(char[] s) {
        helper(s, 0, s.length-1);
    }
    
    void helper(char[] s, int ind, int len) {
        if(ind>=len) return;
        char temp = s[ind];
        s[ind] = s[len];
        s[len] = temp;
        helper(s, ind+1, len-1);
    }
}