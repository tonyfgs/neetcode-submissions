class Solution {
    public int numDecodings(String s) {
        char[] tab = s.toCharArray();
        int count = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] == '0'){
                break;
            }

            if(tab[i] == '1'){
                count=+2;
                continue;
            }
            if(tab[i] == '2' && tab[i+1] <= '6' && i < tab.length-1 ){
                count=+2;
                continue;
            }
            count++;
        }

        return count;
    }
}
