class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] arr = new int[nums.length + 1];

        for(int[] q : queries){
            arr[q[0]] += 1;
            arr[q[1] + 1] -= 1;
        }

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += arr[i];
            arr[i] = sum;
            if(arr[i] < nums[i]){
                return false;
            }
        }

        return true;
    }
}