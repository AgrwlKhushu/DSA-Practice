import java.util.*;

class Solution {
    private static final int[][] C5 = buildC5();

    public int triangularSum(int[] nums) {
        int n = nums.length;
        int N = n - 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c2 = combMod2(N, i);
            int c5 = combMod5(N, i);
            int c10 = crt10(c2, c5);
            ans = (ans + c10 * nums[i]) % 10;
        }
        return ans;
    }

    private static int combMod2(int N, int i) {
        return ((i & (N - i)) == 0) ? 1 : 0;
    }

    private static int combMod5(int N, int i) {
        int res = 1;
        int n = N, k = i;
        while (n > 0 || k > 0) {
            int nd = n % 5, kd = k % 5;
            if (kd > nd) return 0;
            res = (res * C5[nd][kd]) % 5;
            n /= 5; k /= 5;
        }
        return res;
    }

    private static int crt10(int r2, int r5) {
        int r = r5;
        if ((r & 1) != r2) r += 5;
        return r;
    }

    private static int[][] buildC5() {
        int[][] c = new int[5][5];
        for (int a = 0; a < 5; a++) {
            c[a][0] = c[a][a] = 1;
            for (int b = 1; b < a; b++) c[a][b] = (c[a-1][b-1] + c[a-1][b]) % 5;
        }
        return c;
    }

    static int triangularSumSlow(int[] nums) {
        int[] a = Arrays.copyOf(nums, nums.length);
        for (int len = a.length; len > 1; len--) {
            for (int j = 0; j < len - 1; j++) a[j] = (a[j] + a[j+1]) % 10;
        }
        return a[0];
    }
}