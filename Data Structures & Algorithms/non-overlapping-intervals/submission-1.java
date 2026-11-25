class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            if(currentInterval[1] > intervals[i][0]){
                if(currentInterval[1] > intervals[i][1]){
                    currentInterval = intervals[i];
                }
                res++;
                continue;
            }
            currentInterval = intervals[i];
        }       
        return res;
    }
}
