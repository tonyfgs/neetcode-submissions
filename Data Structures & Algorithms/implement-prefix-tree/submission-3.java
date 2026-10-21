class PrefixTree {

    HashMap<Character ,PrefixTree> next;
    boolean isEnd;
    

    public PrefixTree() {
        next = new HashMap<>();
        isEnd = false;
    }

    public void insert(String word) {
        PrefixTree cursor = this;
        for (int i = 0; i < word.length(); i++) {
            PrefixTree tmp = cursor.next.get(word.charAt(i));
            if (tmp == null) {
                tmp = new PrefixTree();
                cursor.next.put(word.charAt(i), tmp);
            }
            cursor = tmp;
        }
        cursor.isEnd = true;
    }   

    public boolean search(String word) {
        PrefixTree cursor = this;
        for (int i = 0; i < word.length(); i++){
            cursor = cursor.next.get(word.charAt(i));
            if(cursor == null) {
                return false;
            }
        }
        return cursor.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree cursor = this;
        for (int i = 0; i < prefix.length(); i++){
           cursor = cursor.next.get(prefix.charAt(i));
            if(cursor == null) {
                return false;
            }
        }
        return true;
    }
}
