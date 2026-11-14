class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] possible = new boolean[s.length()+1];
        possible[0] = true;

        for (int i = 0; i < s.length(); i++){
            if(!possible[i]){
                continue;
            }

            for(String matches: wordSet){
                if (i+ matches.length() < s.length()){
  String value = s.substring(i, i+ matches.length());
                if(value.equals(matches)){
                    possible[i+matches.length()] = true;
                }
                }
              
            }
        }

        return possible[s.length()];
    }
}
