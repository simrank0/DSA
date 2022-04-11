package DP;

/**
 * https://leetcode.com/problems/coin-change-2/
 * Unbounded Knapsack Problem
 */
public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 5;
        CoinChange2 coinChange2 = new CoinChange2();
        System.out.println(coinChange2.change(target, coins));
    }
    public int change(int amount, int[] coins) {

//        return isPossible(amount, coins, 0);
//        return dfs(coins, 0, amount, new Integer[coins.length][amount+1]);

        //Space optimized dp
        int n = coins.length;
        int[][] dp = new int[2][amount + 1];
        dp[0][0] = 1;
        dp[1][0] = 1;

        //Time: O(n * amount), where n is length of coins
        //Space: O(amount)

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j]; // skip ith coin
                if (j >= coins[i - 1])
                    dp[i % 2][j] += dp[i % 2][j - coins[i - 1]]; // use ith coin
            }
        }
        return dp[n % 2][amount];
    }

    //Recursion
    int isPossible(int amount, int[] coins, int index){
        if(amount==0) return 1;
        if(index>=coins.length || amount<0) return 0;
        return isPossible(amount-coins[index], coins, index) + isPossible(amount, coins, index+1);
    }

    //Top down dp
    int dfs(int[] coins, int i, int amount, Integer[][] dp) {
        if (amount == 0) return 1;
        if (i == coins.length) return 0;
        if (dp[i][amount] != null) return dp[i][amount];
        int ans = dfs(coins, i + 1, amount, dp); // skip ith coin
        if (amount >= coins[i])
            ans += dfs(coins, i, amount - coins[i], dp); // use ith coin
        return dp[i][amount] = ans;
    }
}
