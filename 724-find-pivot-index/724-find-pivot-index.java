class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int n : nums){
            totalSum += n;
        }
        
        int currentSum = 0;
        for(int i = 0; i< nums.length ; i++){
            int leftOver = totalSum - nums[i] - currentSum;
            // 11 --> 28 - 6 - 11
            if(currentSum == leftOver){
                return i;
            } else {
                currentSum += nums[i];
            }
        } 
        return -1;
    }
}