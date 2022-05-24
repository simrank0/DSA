class Solution {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0, max = 0;
        for(char c : s.toCharArray()) {
            if(c==')') r++;
            else l++;
            if(l==r) max = Math.max(max, l<<1);
            if(r>l) l=r=0;
        }
        
        l = r = 0;
        for(int i = s.length()-1; i>=0; i--) {
            if(s.charAt(i)==')') r++;
            else l++;
            if(l==r) max = Math.max(max, l<<1);
            if(l>r) l=r=0;
        }
        return max;
    }
}