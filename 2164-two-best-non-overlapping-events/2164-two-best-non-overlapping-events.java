class Solution {
    public int maxTwoEvents(int[][] events) 
    {
        long[] start = new long[events.length], end = new long[events.length];
        for(int i = 0; i < events.length; i++)
        {
            long startValue = ((long) events[i][0] << 32) | (0xFFFF_FFFFL & i);
            long endValue = ((long) (events[i][1]+1) << 32) | (0xFFFF_FFFFL & i);
            start[i] = startValue;
            end[i] = endValue;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int last = 0, sum = 0;
        for(int i = 0, j = 0; i < events.length && j < events.length;)
        {
            int startTime = (int)((start[i] >> 32) & 0xFFFF_FFFFL);
            int startIdx = (int)(start[i] & 0xFFFF_FFFFL);
            int endTime = (int)((end[j] >> 32) & 0xFFFF_FFFFL);
            int endIdx = (int)(end[j] & 0xFFFF_FFFFL);
            if(startTime < endTime)
            {
                sum = Math.max(sum, last + events[startIdx][2]);
                ++i;
            }else{
                
                last = Math.max(last, events[endIdx][2]);
                ++j;
            }
        }
        return sum;
    }
}