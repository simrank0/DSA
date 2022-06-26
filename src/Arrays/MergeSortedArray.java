package Arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = n-1, k = m-1;;
        for(int i = m+n-1; i>=0; i--) {
            if(k<0) nums1[i] = nums2[j--];
            else if(j<0) nums1[i] = nums1[k--];
            else nums1[i] = nums1[k]>nums2[j] ? nums1[k--] : nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        MergeSortedArray obj = new MergeSortedArray();
        obj.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
