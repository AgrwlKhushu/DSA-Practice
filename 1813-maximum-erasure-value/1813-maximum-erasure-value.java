class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int l = 0, r = 0;
        int currSum = 0, maxSum = 0;

        while(r < nums.length){
            while(set.contains(nums[r])){
                set.remove(nums[l]);
                currSum -= nums[l];
                l++;
            }

            set.add(nums[r]);
            currSum += nums[r];
            maxSum = Math.max(currSum, maxSum);
            r++;
        }   

        return maxSum;
    }
}