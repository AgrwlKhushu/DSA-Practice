class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int NEG = -1_000_000_000;

        int[] dp = new int[m + 1];
        for (int j = 0; j <= m; j++) dp[j] = NEG;

        for (int i = 1; i <= n; i++) {
            int[] ndp = new int[m + 1];
            for (int j = 0; j <= m; j++) ndp[j] = NEG;

            for (int j = 1; j <= m; j++) {
                int prod = nums1[i - 1] * nums2[j - 1];
                int take = dp[j - 1] == NEG ? prod : Math.max(prod, dp[j - 1] + prod);

                int best = take;
                best = Math.max(best, dp[j]);
                best = Math.max(best, ndp[j - 1]);

                ndp[j] = best;
            }
            dp = ndp;
        }
        return dp[m];
    }
}