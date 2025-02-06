class Solution {
    public int tupleSameProduct(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mul = arr[i] * arr[j];
                int count = map.getOrDefault(mul, 0);
                ans += count;
                map.put(mul, count + 1);
            }

        }

        return ans * 8;
    }
}