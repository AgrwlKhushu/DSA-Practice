class Solution {
    static final int MOD = 1000000007;

    public long power(long x, long y, long mod){
        if(y == 0){
            return 1;
        }

        long p = power(x, y / 2, mod) % mod;

        p = (p * p) % mod;
        return (y % 2 == 0) ? p : (x * p) % mod;
    }

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenCount = power(5, evenPositions, MOD);
        long oddCount = power(4, oddPositions, MOD);

        return (int) ((evenCount * oddCount) % MOD);
        
    }
}
