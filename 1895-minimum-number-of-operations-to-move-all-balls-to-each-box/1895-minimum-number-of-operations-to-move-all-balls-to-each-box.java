class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        int all = 0;
        for(int i = 0; i < n; i++){
            if(boxes.charAt(i) == '1'){
                all++;//How many balls 
                res[0] += i;
            }
        }
        if(all == 0) return res;
        int left = boxes.charAt(0) == '1'? 1:0;
        int right = all -left;
        for(int i = 1;i < n;i++){
            res[i] = res[i - 1] - right + left;
            if(boxes.charAt(i) == '1'){
                left++;
                if(right > 0){
                    right--;
                }
            } 
        }
        return res;
    }
}