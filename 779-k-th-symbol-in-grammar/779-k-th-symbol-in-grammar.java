class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1 && k==1) return 0;
        double mid = Math.pow(2, n-1)/2;
        if(k <= mid) return kthGrammar(n-1, k);
        else {
            int num = kthGrammar(n-1, (int)(k-mid));
            return 1-num;
        }
    }
}