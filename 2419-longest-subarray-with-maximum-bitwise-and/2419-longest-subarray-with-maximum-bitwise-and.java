class Solution {
    public int longestSubarray(int[] nums) {
        int maxA = 0;
        for (int n : nums)
            maxA = Math.max(maxA, n);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxA) {
                int c1 = 0;
                while (i < nums.length && nums[i] == maxA) {
                    c1++;
                    i++;
                }
                count = Math.max(count, c1);
                i--;
            }
        }
        return count;

    }
}