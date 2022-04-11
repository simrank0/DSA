package DP;

import java.util.Arrays;

public class MinimumCostToCutAStick {
    public static void main(String[] args) {
        int n = 9;
        int[] cuts = {5,6,1,4,2};
        MinimumCostToCutAStick obj = new MinimumCostToCutAStick();
        System.out.println(obj.minCost(n, cuts));
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[][] dp = new int[m+1][m+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= m - i; j++) {
                int k = j + i;
                int min = Integer.MAX_VALUE;
                for (int p = j; p < k; p++) {
                    min = Math.min(min, dp[j][p] + dp[p + 1][k]);
                }
                int len = (k == m ? n: cuts[k]) - (j == 0 ? 0 : cuts[j - 1]);
                dp[j][k] = min + len;
            }
        }
        return dp[0][m];
    }
}
