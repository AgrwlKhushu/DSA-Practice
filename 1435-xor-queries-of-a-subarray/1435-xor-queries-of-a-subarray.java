class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n];

        pre[0] = arr[0];
        for(int i = 1; i < n; i++){
            pre[i] = pre[i - 1] ^ arr[i];
        }

        int[] ans = new int[queries.length];

        for(int k = 0; k < queries.length; k++){
            int i = queries[k][0];
            int j = queries[k][1];

            if(i == 0){
                ans[k] = pre[j];
            }
            else{
                ans[k] = pre[j] ^ pre[i - 1];
            }
        }
        return ans;
    }
}