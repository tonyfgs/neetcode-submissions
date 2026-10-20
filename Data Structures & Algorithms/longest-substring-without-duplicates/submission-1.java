class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> windows = new HashSet<>();
        int d = 0;
        int e = 0;
        int max = 0;
        for(char c: s.toCharArray()) {

            while(windows.contains(c)) {
                windows.remove(s.charAt(d));
                d++;
            }
            windows.add(c);
            max = Math.max(windows.size(), max);
            e++;
        }
        return max;
    
    }
}
