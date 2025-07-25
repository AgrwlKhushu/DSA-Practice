class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int w = 0, min = Integer.MAX_VALUE;
        int[] bits = new int[32];
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] >= k) return 1;
            w |= nums[r];
            for (int i = 0; i < bits.length; i++) {
                bits[i] += (nums[r] >> i) & 1;
            }
            while (w >= k) {
                min = Math.min(min, r - l + 1);
                for (int i = 0; i < bits.length; i++) {
                    bits[i] -= (nums[l] >> i) & 1;
                    if (bits[i] == 0) w &= ~(1 << i);
                }
                l++;
            } 
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int prefix_bs(int[] nums, int k) { 
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) return 1;
            prefix[i + 1] = prefix[i] | nums[i];
        }
        System.out.println(Arrays.toString(prefix));
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prefix.length; i++) {
            if (prefix[i] >= k) {
                int l = 0, r = i;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    int s = prefix[i] & ~prefix[m];
                    if (s < k) {
                        r = m;
                    } else {
                        l = m + 1;
                        min = Math.min(min, i - m);
                    }
                }
            }
        }
        return min;
    }
}