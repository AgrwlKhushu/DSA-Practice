class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        Integer[] index = new Integer[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            index[i] = i;
        }
        Arrays.sort(index, (o, p) -> intervals.get(o).get(0) - intervals.get(p).get(0));
        PriorityQueue<long[]>[] queue = new PriorityQueue[5];
        for (int i = 0; i < 5; i++) {
            queue[i] = new PriorityQueue<>((o, p) -> Long.compare(o[0], p[0]));
        }
        long dp[][][] = new long[intervals.size()][4][2], curr[][] = new long[4][2], max = 0;
        int[] result = new int[] { intervals.size(), intervals.size(), intervals.size(), intervals.size() };
        for (int i : index) {
            for (int j = 0; j < 4; j++) {
                for (; !queue[j].isEmpty() && queue[j].peek()[0] < intervals.get(i).get(0); queue[j].poll()) {
                    curr[j] = Arrays.compare(curr[j], new long[] { queue[j].peek()[2], -queue[j].peek()[1] }) > 0 ? curr[j] : new long[] { queue[j].peek()[2], -queue[j].peek()[1] };
                }
            }
            for (int j = 0; j < 4; j++) {
                if (curr[j][0] > 0) {
                    queue[j + 1].add(new long[] { intervals.get(i).get(1), i, curr[j][0] + intervals.get(i).get(2) });
                    dp[i][j] = new long[] { curr[j][0] + intervals.get(i).get(2), -curr[j][1] };
                    max = Math.max(max, curr[j][0] + intervals.get(i).get(2));
                }
            }
            queue[1].add(new long[] { intervals.get(i).get(1), i, intervals.get(i).get(2) });
            dp[i][0] = new long[] { intervals.get(i).get(2), 1 };
            max = Math.max(max, intervals.get(i).get(2));
        }
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < 4; j++) {
                if (dp[i][j][0] == max) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int k = j, l = i; k >= 0 && l >= 0; l = (int) dp[l][k--][1]) {
                        list.add(l);
                    }
                    Collections.sort(list);
                    result = Arrays.compare(result, list.stream().mapToInt(t -> t).toArray()) < 0 ? result : list.stream().mapToInt(t -> t).toArray();
                }
            }
        }
        return result;
    }
}