package DP;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 */

public class PartitionEqualSubsetSum {
    boolean[] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum+=i;
        dp = new boolean[sum/2];
        if(sum%2==1) return false;
        else return call(nums, 0, sum/2);
    }
    boolean call(int[] a, int ind, int sum){
        if(sum==0) return true;
        if(ind>=a.length) return false;
        if(a[ind]<=sum)
            if(!dp[sum-a[ind]]){
                dp[sum-a[ind]] = true;
                return call(a, ind+1, sum-a[ind]) || call(a, ind+1, sum);
            }
        return call(a, ind + 1, sum);
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
        int[] nums1 = {1,5,11,5};
        int[] nums2 = {1,2,3,5};

        //Expected: True -> [11], [1, 5, 5]
        System.out.println(obj.canPartition(nums1));
        //Expected: False
        System.out.println(obj.canPartition(nums2));
    }
}
