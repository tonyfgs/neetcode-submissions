class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\s+", "");
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        char[] charTab = s.toCharArray();

        for(int i = 0; i < charTab.length; i++) {
            if (charTab.length -i < i) {
                return true;
            }

            if (charTab[i] != charTab[charTab.length -1  -i]){
                return false;
            }
        }
        return true;
    }
}
