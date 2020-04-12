package dynamic;

import java.util.Arrays;

public class CoinChange {
    private static int[][] dp;
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        dp = new int[coins.length][sum + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(count(sum, coins.length - 1, coins));
    }

    private static int count(int sum, int index, int[] coins) {
        if(index < 0)
            dp[index][sum] = 0;
        if(dp[index][sum] != -1)
            return dp[index][sum];
        if (sum == 0)
            dp[index][sum] = 1;
        if (sum < 0)
            dp[index][sum] = 0;
        dp[index][sum] = count(sum - coins[index], index, coins) + count(sum, index - 1, coins);
        return dp[index][sum];
    }
}
