class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;
        for(int num : arr){
            if(map.get(num) == num){
                max = Math.max(max, num);
            }
        }

        return max;
    }
}