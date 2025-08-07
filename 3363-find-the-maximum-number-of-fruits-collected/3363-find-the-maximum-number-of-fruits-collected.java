class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        for(int i = 1; i < n; i++) {
            fruits[i][i] += fruits[i-1][i-1];
            for(int j = i+1; j < n; j++) {
                if(i+j < n-1) continue;
                
                fruits[i][j] += Math.max(j == n-1 ? 0 : fruits[i-1][j+1], i + j == n-1 ? 0 : Math.max(fruits[i-1][j], j == 0 || i + j <= n ? 0 : fruits[i-1][j-1]));
                fruits[j][i] += Math.max(j == n-1 ? 0 : fruits[j+1][i-1], i + j == n-1 ? 0 : Math.max(fruits[j][i-1], j == 0 || i + j <= n ? 0 : fruits[j-1][i-1]));
            }
        }
        return fruits[n-1][n-2] + fruits[n-2][n-1] + fruits[n-1][n-1];
    }
}