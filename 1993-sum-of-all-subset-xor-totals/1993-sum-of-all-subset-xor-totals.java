class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums , 0 , 0);
    }

    public int helper(int[] nums, int index, int currValue){
        if(index == nums.length) return currValue;

        return helper(nums, index+1, currValue^nums[index]) + helper(nums, index+1, currValue);
    }
}