class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
    
        int i =0;
        int n = intervals.length;
        int[] currentInterval = intervals[0];
        while(i < n){
            // if the end time of the current int override the start of other interval
            if(currentInterval[1] >= intervals[i][0]){
                currentInterval[0] = Math.min(intervals[i][0], currentInterval[0]);
                currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);
            }
            // else the current intervals is no longer in the interval that we treat so we add it in the result
            else {
                res.add(currentInterval);
                currentInterval = intervals[i];
            }
            i++;
        }
        res.add(currentInterval);
        return res.toArray(new int[res.size()][]);
    }
}
