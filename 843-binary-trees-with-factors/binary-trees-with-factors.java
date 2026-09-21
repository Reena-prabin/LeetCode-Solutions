class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int value = arr[i] / arr[j];
                    for (int k = 0; k < i; k++) {
                        if (arr[k] == value) {
                            dp[i] = (dp[i] + dp[j] * dp[k]) % MOD;
                            break;
                        }
                    }
                }
            }
        }
        long ans = 0;
        for (long x : dp) {
            ans = (ans + x) % MOD;
        }
        return (int) ans;
    }
}