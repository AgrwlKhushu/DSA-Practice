class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        final int N = edges1.length + 1;
        final int M = edges2.length + 1;

        if (k == 0) {
            int[] res = new int[N];
            Arrays.fill(res, 1);
            return res;
        }

        List<Integer>[] tree1 = buildAdj(edges1, N);
        List<Integer>[] tree2 = buildAdj(edges2, M);

        int[][] dp1 = new int[N][k + 1];
        int[][] dp2 = new int[M][k];
        int[] parent1 = new int[N];
        int[] parent2 = new int[M];
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        dfs(0, -1, tree1, parent1, dp1, q1, k);
        dfs(0, -1, tree2, parent2, dp2, q2, k - 1);

        int[][] backtrack1 = new int[N][k + 1];
        int[][] backtrack2 = new int[M][k];
        int[] count1 = new int[N];
        int[] count2 = new int[M];

        calcBacktrack(q1, parent1, dp1, backtrack1, count1, k);
        calcBacktrack(q2, parent2, dp2, backtrack2, count2, k - 1);

        int maxConnectivity = 1;
        for (int count : count2)
            maxConnectivity = Math.max(maxConnectivity, count);

        for (int v = 0; v < N; v++)
            count1[v] += maxConnectivity;

        return count1;
    }

    private List<Integer>[] buildAdj(int[][] edges, int vertexCount) {
        List<Integer>[] tree = new List[vertexCount];
        int u, v;
        for (int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            if (tree[u] == null) tree[u] = new LinkedList<>();
            if (tree[v] == null) tree[v] = new LinkedList<>();
            tree[u].add(v);
            tree[v].add(u);
        }
        return tree;
    }

    private void dfs(int v, int p, List<Integer>[] adj, int[] parent, int[][] dp, Queue<Integer> q, int k) {
        dp[v][0] = 1;
        q.offer(v);
        parent[v] = p;

        if (adj[v] != null)
            for (int u : adj[v]) {
                if (u == p) continue;
                dfs(u, v, adj, parent, dp, q, k);
            }

        if (p == -1) return;

        for (int d = 1; d <= k; d++)
            dp[p][d] += dp[v][d - 1];
    }

    private void calcBacktrack(Queue<Integer> q, int[] parent, int[][] dp, int[][] backtrack, int[] count, int k) {
        int v, p;

        while (!q.isEmpty()) {
            v = q.poll();
            p = parent[v];

            count[v] = dp[v][0];

            if (k >= 1) {
                if (p != -1)
                    backtrack[v][1] = 1;
                count[v] += dp[v][1] + backtrack[v][1];
            }

            for (int d = 2; d <= k; d++) {
                if (p != -1)
                    backtrack[v][d] = dp[p][d - 1] - dp[v][d - 2] + backtrack[p][d - 1];
                count[v] += dp[v][d] + backtrack[v][d];
            }
        }
    }
}
