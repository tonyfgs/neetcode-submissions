class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int i =1;
        int n = intervals.length;
        int[] currentInterval = intervals[0];
        while(i < n){
            // if the end time of the current int override the start of other interval
            if(currentInterval[1] >= intervals[i][0] && currentInterval[0] <= intervals[i][1]){
                currentInterval[0] = Math.min(intervals[i][0], currentInterval[0]);
                currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);
            }
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
