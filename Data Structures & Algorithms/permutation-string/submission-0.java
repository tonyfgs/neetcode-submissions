class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> fre1 = new HashMap<>();
        Map<Character, Integer> fre2 = new HashMap<>();
        int deb =0;
        int end = 0;
        for (int i = 0; i < s1.length(); i++) {
            fre1.put(s1.charAt(i), fre1.getOrDefault(s1.charAt(i), 0) +1);
        }    

        for (int i = 0; i < s2.length(); i++){
            end++;
            fre2.put(s2.charAt(i), fre2.getOrDefault(s2.charAt(i), 0) +1);
            int wdSize = end - deb;
            if (wdSize < s1.length()) {
                continue;
            }

            if (fre1.equals(fre2)){
                return true;
            }

            char de = s2.charAt(deb);

            fre2.put(de, fre2.get(de) -1);

            if (fre2.get(de) == 0) {
                fre2.remove(de);
            }
            deb++;

        }

        return false;


    }
}
