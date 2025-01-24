class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowCount = new int[n];
        int[] columnCount = new int[m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    rowCount[i]++;
                    columnCount[j]++;
                    count++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    if(rowCount[i] == 1 && columnCount[j] == 1){
                        count--;
                    }
                }
            }
        }

        return count;
    }
}