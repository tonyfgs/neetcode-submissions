class WordDictionary {

    class TrieNode {
        HashMap<Character, TrieNode> trieMap;
        boolean end;
        public TrieNode() {
           trieMap = new HashMap<>();
           end = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cursor = this.root;
            for(int i = 0; i < word.length(); i++){
                TrieNode tmp = cursor.trieMap.get(word.charAt(i));
                if(tmp == null) {
                    tmp = new TrieNode();
                    cursor.trieMap.put(word.charAt(i), tmp);
                }
                cursor = tmp;
            }
            cursor.end = true;
    }

    public boolean search(String word) {
        return searchAt(word, this.root);
    }

    private boolean searchAt(String word, TrieNode root){
        TrieNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                for (Map.Entry<Character, TrieNode> entry : cursor.trieMap.entrySet()) {
                    if (searchAt(word.substring(i + 1, word.length()), entry.getValue())) {
                        return true; 
                    }
                }
            }
            TrieNode tmp = cursor.trieMap.get(word.charAt(i));
            if(tmp == null) {
                return false;
            }
            cursor = tmp;
        }
        return true;
    }
}
