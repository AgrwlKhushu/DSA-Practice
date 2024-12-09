class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            if((nums[i]-nums[i-1])%2==0){
                prefix[i] = prefix[i-1]+1;
            } else {
                prefix[i] = prefix[i-1];
            }
        }
        boolean[] res = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
           int start = queries[i][0], end = queries[i][1];
           if(prefix[end]==prefix[start])
           res[i] = true;
        }
        return res;
    }
}