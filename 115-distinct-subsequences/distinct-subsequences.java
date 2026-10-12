class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[j] stores the number of distinct subsequences of prefix of s matching t[0...j-1]
        // Using a 1D array for space optimization (O(n) space)
        int[] dp = new int[n + 1];
        
        // Base case: An empty string t can always be formed 1 time by any prefix of s
        dp[0] = 1;
        
        for (int i = 1; i <= m; i++) {
            // Traverse backwards to avoid overwriting values needed from the previous row
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        
        return dp[n];
    }
}