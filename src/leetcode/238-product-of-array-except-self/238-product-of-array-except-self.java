class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int zerothIndex = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0) totalProduct *= nums[i];
            else if(zerothIndex!=-1) zerothIndex=-2;
            else zerothIndex = i;
        }

		//Handle cases including zero by storing index holding '0' (if only one zero, need to store totalProduct. else everything zeroes out
        if(zerothIndex!=-1){
            Arrays.fill(nums,0);
            for(int i=0; i<nums.length; i++) nums[i] = 0; 
            if(zerothIndex!=-2) nums[zerothIndex] = (int)totalProduct;
            return nums;
        }
        else
            for(int i=0; i<nums.length; i++) nums[i] = (totalProduct/nums[i]);

        return nums;
    }
}