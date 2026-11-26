/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        int lastEnd = intervals.get(0).end;
        int res = 1;
        for (int i = 1; i < intervals.size(); i++){
            
            if (lastEnd > intervals.get(i).start){
                res++;
            }
           
                lastEnd = intervals.get(i).end;
            
        }
        return res;
    }
}
