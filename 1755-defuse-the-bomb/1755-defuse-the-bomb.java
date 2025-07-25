class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0) return res;

        int start = 1, end = k, sum = 0;
        if (k < 0) {
            start = n - Math.abs(k);
            end = n - 1; 
        }
        for (int i = start; i <= end; i++) {
            sum += code[i % n];
        }

        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum -= code[start % n];
            sum += code[(end + 1) % n];
            start++;
            end++;
        }

        return res;
    }
    public int[] decryptBruteForce(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n]; 
        if (k == 0) return res;

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = i + 1; j < i + 1 + k; j++) {
                    res[i] += code[j % n];
                }
            } else {
                for (int j = i - Math.abs(k); j < i; j++) {
                    res[i] += code[(j + n) % n];
                }
            }
        }

        return res;
    }
}