class Solution {

    public String encode(List<String> strs) {
        String finalString = "";

        for(String word: strs) {
            int size = word.length();

            finalString += size + "%" + word;
        }

        return finalString;

    }

    public List<String> decode(String str) {
        List<String> words = new ArrayList<String>();
        int i = 0;
        while (i < str.length()){
            int wordEnd = str.indexOf('%', i);
            int index = Integer.parseInt(str.substring(i, wordEnd));
            words.add(str.substring(wordEnd+1, wordEnd+1+index));
            
            i = wordEnd + 1 + index;
        }   
        return words;
    }
}
