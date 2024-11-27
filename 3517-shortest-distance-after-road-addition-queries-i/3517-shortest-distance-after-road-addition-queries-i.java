class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] dp = new int[n];
        Arrays.setAll(dp, i -> i);
        List<Integer>[] from = new List[n];
        Arrays.setAll(from, i -> new ArrayList<>());
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x = queries[i][0], y = queries[i][1];
            from[y].add(x);
            if (dp[x] + 1 < dp[y]) {
                for (int j = y; j < n; j++) {
                    dp[j] = Math.min(dp[j], dp[j - 1] + 1);
                    for (int f : from[j]) {
                        dp[j] = Math.min(dp[j], dp[f] + 1);
                    }
                }
            }
            ans[i] = dp[n - 1];
        }
        return ans;
    }
}