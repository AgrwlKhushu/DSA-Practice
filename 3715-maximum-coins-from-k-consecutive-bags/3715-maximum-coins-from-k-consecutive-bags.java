class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (o, p) -> o[0] - p[0]);
        long dp[] = new long[coins.length + 1], max = 0;
        for (int i = 0; i < coins.length; i++) {
            dp[i + 1] = dp[i] + (coins[i][1] - coins[i][0] + 1L) * coins[i][2];
        }
        for (int i = 0; i < coins.length; i++) {
            int left1 = i, right1 = coins.length - 1, left2 = 0, right2 = i;
            while (left1 < right1) {
                int mid = (left1 + right1) / 2;
                if (coins[mid][1] - coins[i][0] + 1 < k) {
                    left1 = mid + 1;
                } else {
                    right1 = mid;
                }
            }
            while (left2 < right2) {
                int mid = (left2 + right2 + 1) / 2;
                if (coins[i][1] - coins[mid][0] + 1 < k) {
                    right2 = mid - 1;
                } else {
                    left2 = mid;
                }
            }
            max = Math.max(max, Math.max(dp[left1 + 1] - dp[i] - Math.max(0L, Math.min(coins[left1][1] - coins[i][0] + 1 - k, coins[left1][1] - coins[left1][0] + 1)) * coins[left1][2], dp[i + 1] - dp[left2] - Math.max(0L, Math.min(coins[i][1] - coins[left2][0] + 1 - k, coins[left2][1] - coins[left2][0] + 1)) * coins[left2][2]));
        }
        return max;
    }
}