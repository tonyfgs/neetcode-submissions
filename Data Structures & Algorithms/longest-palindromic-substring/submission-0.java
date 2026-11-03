class Solution {
    public String longestPalindrome(String s) {
        char[] charTab = s.toCharArray();
        int bestL = 0;
        int bestStart = 0;
        for (int i = 0; i < charTab.length; i++){
            int end = i;
            while(end < charTab.length){
               if(isValid(charTab,i, end)){
                    if (end-i+1 > bestL){
                        bestL = end-i;
                        bestStart = i;
                    }
               }
               end++;
            }
        }
        return new String(charTab, bestStart , bestStart+bestL);
    }

    private boolean isValid(char[] current,int start ,int end){
        
        int left = start;
        int right = end;

        while(left  <= right){
            if(current[left] != current[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
