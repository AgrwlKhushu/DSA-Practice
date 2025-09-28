class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;

        selectAndSwapMax(nums, n - 1);
        selectAndSwapMax(nums, n - 2);

        for (int i = n - 1; i >= 2; i--) {

            selectAndSwapMax(nums, i - 2);

            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }

    private void selectAndSwapMax(int[] nums, int idx) {
        int maxValue = nums[0];
        int maxIndex = 0;

        for (int i = 1; i <= idx; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        int temp = nums[idx];
        nums[idx] = maxValue;
        nums[maxIndex] = temp;
    }
}