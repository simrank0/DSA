package Arrays;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray r = new ShortestUnsortedContinuousSubarray();
        System.out.println(r.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int start = Integer.MAX_VALUE, end = 0;
        int popped = nums[0];
        for(int i=0; i<nums.length;  i++){
            if((stack.isEmpty() || nums[stack.peek()]<=nums[i]) && popped<=nums[i]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                    int t = stack.pop();
                    popped = Math.max(nums[t], popped);
                    start = Math.min(start, t);
                }
                stack.push(i);
                // System.out.println(start + " " + end);
                start = start==Integer.MAX_VALUE? i : start;
                end = i;
            }
        }
        if(start == Integer.MAX_VALUE) return 0;
        return end - start + 1;
    }
}
