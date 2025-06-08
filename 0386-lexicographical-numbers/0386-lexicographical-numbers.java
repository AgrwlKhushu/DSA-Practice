class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> series = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            generateSeries(i, n, series);
        }
        return series;
    }

    private void generateSeries(int curr, int limit, List<Integer> ser){
        if(curr > limit) return;
        ser.add(curr);

        for(int digit = 0; digit <= 9; digit++){
            int nextNum = curr * 10 + digit;
            if(nextNum <= limit){
                generateSeries(nextNum, limit, ser);
            } 
        }
    }
}