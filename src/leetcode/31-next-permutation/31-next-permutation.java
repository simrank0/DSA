class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0) {
            int j = nums.length-1;
            while(j>i && nums[j]<=nums[i]) j--;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        Arrays.sort(nums, i+1, nums.length);
    }
}