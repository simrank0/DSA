class Solution {
    public int findDuplicate(int[] nums) {
        int d = -1, n=nums.length;
        for(int i = 0; i<n; i++){
            int cur = Math.abs(nums[i]);
            if(nums[cur]<0){
                d = cur;
                break;
            }
            nums[cur] *= -1;
        }
        for(int i = 0; i<n; i++){
            nums[i] = Math.abs(nums[i]);
        }
        return d;
    }
}