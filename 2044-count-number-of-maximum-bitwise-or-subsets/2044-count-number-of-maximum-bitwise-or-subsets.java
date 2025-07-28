class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int or = 0;
        for (int i : nums) {
            or |= i;
        }
        return traverse(nums, 0, 0, or);
    }

    private int traverse(int[] nums, int idx, int t, int or) {
        if (idx == nums.length) {
            return t == or ? 1 : 0;
        }
        if (t == or) {
            return 1 << nums.length - idx;
        }
        return traverse(nums, idx + 1, t, or) + traverse(nums, idx + 1, t | nums[idx], or);
    }
}