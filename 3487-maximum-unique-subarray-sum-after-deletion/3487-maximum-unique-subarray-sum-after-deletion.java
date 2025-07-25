class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }

        if(max < 0){
            return max;
        }

        int sum = 0;
        for(int num : nums){
            if(num > 0 && !set.contains(num)){
                sum += num;
                set.add(num);
            }
        }

        return sum;
    }
}