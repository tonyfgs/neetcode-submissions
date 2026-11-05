class Solution {
    public int numDecodings(String s) {
        char[] tab = s.toCharArray();
        
        return dfs(tab , 0);
    }


    private int dfs(char[] tab, int index){
        if(index >= tab.length){
            return 1;
        }

        if (tab[index] == '0'){
            return 0;
        }

        int val = dfs(tab, index+1);

        if (tab[index] == '1' && index + 1 < tab.length){
            return val + dfs(tab, index+2);
        }

        if (tab[index] == '2' && index + 1 < tab.length && tab[index+1] >= '0' && tab[index+1] <= '6'){
            return val + dfs(tab, index+2);
        }

        return val;
    }
}
