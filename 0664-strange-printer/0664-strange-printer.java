class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = dp[l][r - 1] + 1;
                for (int k = l; k < r; k++) {
                    if (s.charAt(k) == s.charAt(r)) {
                        int left = 0;
                        if (k > l) {
                            left = dp[l][k - 1];
                        }
                        dp[l][r] = Math.min(
                            dp[l][r],
                            left + dp[k][r - 1]
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}