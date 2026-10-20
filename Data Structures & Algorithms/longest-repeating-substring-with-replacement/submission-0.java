class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int deb = 0;
        int max  = 0;
        Character dom =s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);

            if (map.get(dom) < map.get(c)) {
                dom = c;
            }

            int freq = map.get(dom);
            int windowSize = i - deb +1;
            int need  = windowSize - freq;
            if (need > k) {
                char out = s.charAt(deb);
                map.put(out, map.get(out) -1);
                deb++;
            }

            max =  Math.max(max,  i - deb +1);



        }

        return max;
    }
}
