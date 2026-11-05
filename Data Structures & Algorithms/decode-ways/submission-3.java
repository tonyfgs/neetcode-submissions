class Solution {
    public int numDecodings(String s) {
        char[] tab = s.toCharArray();
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfs(tab , 0, cache);
    }


    private int dfs(char[] tab, int index, int[] cache){

        if(index >= tab.length){
            return 1;
        }

        if (cache[index] != -1){
            return cache[index];
        }

        if (tab[index] == '0'){
            return 0;
        }

        int val = dfs(tab, index+1, cache);

        if (index + 1 < tab.length && (tab[index] == '1' || tab[index] == '2' && tab[index+1] <= '6')){
            val = val + dfs(tab, index+2, cache);
        }

        cache[index] = val;
        return val;
    }
}
