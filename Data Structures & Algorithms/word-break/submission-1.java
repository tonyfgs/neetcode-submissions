class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> wordSet = new HashSet<>();
        for (String word: wordDict) {
            wordSet.add(word);
        }
        int start = 0;
        int end = 1;

        while(end <= s.length()){
            String sub = s.substring(start, end);
            boolean isContain = wordSet.contains(sub);
            if(isContain){
                start = end;
            }
            end ++;

        }

        return start == end-1;
    }
}
