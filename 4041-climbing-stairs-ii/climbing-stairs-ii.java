class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int cost = costs[i - 1];
            dp[i] = dp[i - 1] + cost + 1;
            if (i >= 2) {
                dp[i] = Math.min(
                    dp[i],
                    dp[i - 2] + cost + 4
                );
            }
            if (i >= 3) {
                dp[i] = Math.min(
                    dp[i],
                    dp[i - 3] + cost + 9
                );
            }
        }
        return dp[n];
    }
}