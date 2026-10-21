class PrefixTree {

    HashMap<Character ,PrefixTree> next;
    boolean isEnd;
    

    public PrefixTree() {
        next = new HashMap<>();
        isEnd = false;
    }

    public void insert(String word) {
        PrefixTree horse = this;
        for (int i = 0; i < word.length(); i++){

            horse.next.putIfAbsent(word.charAt(i), new  PrefixTree());
            horse = horse.next.get(word.charAt(i));
        }
        horse.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree horse = this;
        for (int i = 0; i < word.length(); i++){
            if(horse.next.containsKey(word.charAt(i))) {
                horse = horse.next.get(word.charAt(i));
                
            }
            else {
                return false;
            }
            
        }
        if (!horse.isEnd){
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        PrefixTree horse = this;
        for (int i = 0; i < prefix.length(); i++){
           if(horse.next.containsKey(prefix.charAt(i))) {
                horse = horse.next.get(prefix.charAt(i));
            }
            else {
                return false;
            }  
        }
        return true;
    }
}
