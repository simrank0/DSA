class Solution {
    public int pivotIndex(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i = 0; i<nums.length; i++) {
            if(i==0) ans[0] = nums[0];
            else ans[i] = ans[i-1] + nums[i];
        }
        int an = -1;
        for(int i = 0; i<nums.length; i++) {
            if(i==0) {
                if(ans[ans.length-1] - ans[i]==0) {
                    an = i;
                    break;
                }
            }
            else{
                int left = ans[i-1];
                int right = ans[ans.length-1] - ans[i];
                System.out.println(left + " " + right);
                if(left == right) {
                    an = i;
                    break;
                }
            }
        }
        return an;
    }
}