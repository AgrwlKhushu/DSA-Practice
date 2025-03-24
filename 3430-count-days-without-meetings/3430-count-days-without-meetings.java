class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int totalCount = 0;

    public int countDays(int days, int[][] meetings) {
        for (int i = 0; i < meetings.length; i++) {
            var left = meetings[i][0];
            var right = meetings[i][1];
            Map.Entry<Integer, Integer> entry = map.floorEntry(right);
            while (entry != null && entry.getValue() >= left) {
                int existingLeft = entry.getKey();
                int existingRight = entry.getValue();
                totalCount -= existingRight - existingLeft + 1;
                left = Math.min(existingLeft, left);
                right = Math.max(existingRight, right);
                map.remove(existingLeft);
                entry = map.floorEntry(right);
            }
            map.put(left, right);
            totalCount += right - left + 1;
        }

        return days - totalCount;
    }

}