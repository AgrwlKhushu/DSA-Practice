class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long mask;
        n--;

        for (mask = 1; n > 0; mask <<= 1) {
            if ((mask & x) == 0) {
                result |= (n & 1) * mask;
                n >>= 1;
            }
        }

        return result;
    }
}