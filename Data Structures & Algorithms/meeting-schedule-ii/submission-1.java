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
        if(intervals.isEmpty()){
            return 1;
        }
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Interval> queu = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
      
        for (int i = 0; i < intervals.size(); i++){
            
            if (queu.isEmpty()  || queu.peek().end <= intervals.get(i).start){
                queu.poll();
            }
           queu.offer(intervals.get(i));
        }
        return queu.size();
    }
}
