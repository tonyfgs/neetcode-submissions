class Solution {

    public String encode(List<String> strs) {
        
        String finalString = "";
        for (String word: strs) {
            int wordsize = word.length();
            finalString += wordsize + "$" + word; 
        }

        return finalString;

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
       while(i < str.length()) {
            int separator = str.indexOf("$", i);
            if (separator == -1)
                break;
            int size = Integer.parseInt(str.substring(i, separator));

            String word = str.substring(separator + 1, separator+ 1 + size );
            result.add(word);
            i =  separator+ 1 + size;

       }
        return result;
    }
}
