class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, temp = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prices[temp] > max){
                max = prices[i] - prices[temp];
            }
            if(prices[i] - prices[temp] < 0){
                temp = i;
            }
        }
        return max;
    }
}