class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sTab = s.toCharArray();
        char[] tTab = t.toCharArray();

        Arrays.sort(sTab);
        Arrays.sort(tTab);

        return Arrays.equals(sTab, tTab);


    }

}
