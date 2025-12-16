class Solution {
    private static final int NEG_INF = -1_000_000_000;
    private int n, B;
    private int[] present, future;
    private java.util.List<Integer>[] children;

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.n = n;
        this.present = present;
        this.future = future;
        this.B = budget;
        children = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) children[i] = new java.util.ArrayList<>();
        for (int[] e : hierarchy) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            children[u].add(v);
        }
        int[][] rootDP = dfs(0);
        int ans = 0;
        for (int b = 0; b <= B; b++) {
            ans = Math.max(ans, rootDP[0][b]);
        }
        return ans;
    }

    private int[][] dfs(int u) {
        int[] curNot = new int[B + 1];
        int[] curBuy = new int[B + 1];
        java.util.Arrays.fill(curNot, NEG_INF);
        java.util.Arrays.fill(curBuy, NEG_INF);
        curNot[0] = 0;
        curBuy[0] = 0;

        for (int v : children[u]) {
            int[][] child = dfs(v);
            int[] nextNot = new int[B + 1];
            java.util.Arrays.fill(nextNot, NEG_INF);
            for (int b = 0; b <= B; b++) {
                if (curNot[b] == NEG_INF) continue;
                for (int x = 0; x <= B - b; x++) {
                    if (child[0][x] == NEG_INF) continue;
                    nextNot[b + x] = Math.max(nextNot[b + x], curNot[b] + child[0][x]);
                }
            }
            curNot = nextNot;

            int[] nextBuy = new int[B + 1];
            java.util.Arrays.fill(nextBuy, NEG_INF);
            for (int b = 0; b <= B; b++) {
                if (curBuy[b] == NEG_INF) continue;
                for (int x = 0; x <= B - b; x++) {
                    if (child[1][x] == NEG_INF) continue;
                    nextBuy[b + x] = Math.max(nextBuy[b + x], curBuy[b] + child[1][x]);
                }
            }
            curBuy = nextBuy;
        }

        int cu0 = present[u];
        int cu1 = present[u] / 2;
        int gu0 = future[u] - cu0;
        int gu1 = future[u] - cu1;

        int[] dp0 = new int[B + 1];
        int[] dp1 = new int[B + 1];

        for (int b = 0; b <= B; b++) {
            dp0[b] = curNot[b];
            dp1[b] = curNot[b];
        }

        for (int b = cu0; b <= B; b++) {
            if (curBuy[b - cu0] != NEG_INF) {
                dp0[b] = Math.max(dp0[b], curBuy[b - cu0] + gu0);
            }
        }
        for (int b = cu1; b <= B; b++) {
            if (curBuy[b - cu1] != NEG_INF) {
                dp1[b] = Math.max(dp1[b], curBuy[b - cu1] + gu1);
            }
        }

        return new int[][]{dp0, dp1};
    }
}