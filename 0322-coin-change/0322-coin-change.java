class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initialize with a large value (Infinity)
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // Base case
        dp[0] = 0;

        // Process each coin
        for (int coin : coins) {

            for (int j = coin; j <= amount; j++) {

                dp[j] = Math.min(dp[j], dp[j - coin] + 1);

            }
        }

        // If amount cannot be formed
        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }
}