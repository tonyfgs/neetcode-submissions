
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaMap = new HashMap<>();

        for (String word : strs) {
            // 1. On trie les lettres pour obtenir la clé commune
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String cle = new String(chars);

            // 2. Si absente, on crée la liste, puis on ajoute le mot
            anaMap.computeIfAbsent(cle, k -> new ArrayList<>()).add(word);
        }

        // 3. On extrait toutes les listes de la map
        return new ArrayList<>(anaMap.values());
    }
}