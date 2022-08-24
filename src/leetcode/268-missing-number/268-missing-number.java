class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i<nums.length; i++) {
            xor ^= (i+1)^nums[i];
        }
        return xor;
    }
}