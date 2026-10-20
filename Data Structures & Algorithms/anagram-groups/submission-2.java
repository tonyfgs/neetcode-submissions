class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        TreeMap<String, List<String>> anaMap = new TreeMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] currentWord = strs[i].toCharArray();
            Arrays.sort(currentWord);
            String wordSorted = new String(currentWord);
            
            anaMap.computeIfAbsent(wordSorted, k -> new ArrayList<>()).add(strs[i]);
        }

       return new ArrayList<>(anaMap.values());
    }
}
