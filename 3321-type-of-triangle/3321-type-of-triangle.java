class Solution {
    public String triangleType(int[] nums) {
        if(!isTriangle(nums)) return "none";
        if(isEquivalent(nums)) return "equilateral";
        if(isIsosceles(nums)) return "isosceles";
        return "scalene";
    }

    private boolean isTriangle(int[] nums){
        return nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[1] + nums[2] > nums[0];
    }

    private boolean isEquivalent(int[] nums){
        return nums[0] == nums[1] && nums[1] == nums[2];
    }

    private boolean isIsosceles(int[] nums){
        return nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0];
    }
}