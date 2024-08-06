class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for(int i = 0; i < word.length(); i++){
            arr[word.charAt(i) - 'a']++;
        }
        Arrays.sort(arr);
        int cost = 0, count = 0;

        for(int i = 25; i >= 0; i--){
            cost += arr[i] * (count / 8 + 1);
            count++;
        }
        return cost;
    }
}