class Solution {
    public String longestPalindrome(String s) {
        char[] charTab = s.toCharArray();
        int bestL = 0;
        int bestStart = 0;
        for (int i = 0; i < charTab.length; i++){
            int pair = expand(charTab, i, i);
            if(pair > bestL){
                bestL = pair;
                bestStart = i - (pair -1) /2;
            }

            int impair = expand(charTab, i, i+1);
            if(impair > bestL){
                bestL = impair;
                bestStart = i -impair/2+1;
            }
        }



        
        return s.substring(bestStart, bestStart + bestL);
    }

    private int expand(char[] current,int start ,int end){
        
        int left = start;
        int right = end;

        while(left >= 0 && right <= current.length-1 && current[left] == current[right]){
            left--;
            right++;
        }
        return right-left-1;
    }
}
