class Solution {
    public int countSubstrings(String s) {
        char[] charTab = s.toCharArray();
        int result = 0;
        for (int i = 0; i < charTab.length; i++){
            result += expand(charTab, i, i+1) + expand(charTab, i, i);
        }

        return result;
    }

    private int expand(char[] charTab, int start, int end){
        int count = 0;
        while(start >=0 && end < charTab.length && charTab[start] == charTab[end]){
            start--;
            end++;
            count++;
        }

        return count;
    }
}
