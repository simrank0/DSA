class Solution {
    public int numberOfSteps(int n) {
        int count = 0;
        while(n>0) {
            if(n%2 == 1) n-=1;
            else n/=2;
            count++;
        }
        return count;
    }
}