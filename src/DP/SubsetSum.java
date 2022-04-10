package DP;

/**
 * Is subset with the taregt sum possible for the given array? Subset Sum problem
 */
public class SubsetSum {
    static int[] dp;
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 3};
        int target = 9;
        dp = new int[target+1];
        SubsetSum sum = new SubsetSum();
        System.out.println(sum.isPossible(nums, target, 0));
        System.out.println(sum.isPossibleDp(nums, target, 0)==1);
    }

    //Recursive
    boolean isPossible(int[] nums, int target, int ind){
        if(target==0) return true;
        if(ind>= nums.length) return false;
        return isPossible(nums, target-nums[ind], ind+1) || isPossible(nums, target, ind+1);
    }

    //DP
    int isPossibleDp(int[] nums, int target, int ind){
        if(target==0) return 1;
        if(target<0) return -1;
        if(ind>=nums.length) return -1;
        if(dp[target] != 0) return dp[target];
        dp[target] = isPossibleDp(nums, target-nums[ind], ind+1) == 1 ||
                isPossibleDp(nums, target, ind+1) == 1 ? 1 : -1;
        return dp[target];
    }
}
