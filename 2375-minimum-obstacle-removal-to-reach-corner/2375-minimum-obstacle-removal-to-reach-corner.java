class Solution {
    public int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 0}); 
        grid[0][0] = -1;

        while (!dq.isEmpty()) {
            int[] temp = dq.pollFirst();
            int r = temp[0], c = temp[1], obstacle = temp[2];

            if (r == n - 1 && c == m - 1) {
                return obstacle;
            }

            for (int[] d : dir) {
                int row = r + d[0];
                int col = c + d[1];

                if (isValid(row, col, n, m) && grid[row][col] != -1) {
                    if (grid[row][col] == 0) {
                        dq.addFirst(new int[]{row, col, obstacle});
                    } else {
                        dq.addLast(new int[]{row, col, obstacle + 1});
                    }
                    grid[row][col] = -1;
                }
            }
        }

        return -1; 
    }

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}