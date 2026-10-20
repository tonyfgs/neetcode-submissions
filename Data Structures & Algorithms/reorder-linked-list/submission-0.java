class Solution {
    public void reorderList(ListNode head) {
        // Garde-fou : liste vide ou à 1 élément → déjà "reorderée", rien à faire
        if (head == null || head.next == null) return;

        // ════════ ÉTAPE 1 : trouver le milieu ET couper la liste en deux ════════
        ListNode slow = head, fast = head, beforeMid = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;      // le lièvre saute 2
            beforeMid = slow;          // ← le nœud JUSTE AVANT la tortue
            slow = slow.next;          // la tortue avance 1
        }
        beforeMid.next = null;          // ✂️ LA COUPE : deux listes indépendantes
        // [1,2,3,4]  →  first = [1,2]      et      [3,4]

        // ════════ ÉTAPE 2 : renverser la seconde moitié ════════
        ListNode prev = null, curr = slow;   // slow = début de la seconde moitié
        while (curr != null) {
            ListNode next = curr.next;       // 1. sauver la suite
            curr.next = prev;                // 2. retourner la flèche
            prev = curr;                     // 3. prev avance
            curr = next;                     // 4. curr avance
        }
        // [3,4] renversée  →  prev = [4,3]

        // ════════ ÉTAPE 3 : entrelacer les deux moitiés ════════
        ListNode first = head;               // [1,2]
        ListNode second = prev;              // [4,3]
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (first != null && second != null) {
            tail.next = first;   tail = tail.next;   first = first.next;
            tail.next = second;  tail = tail.next;   second = second.next;
        }
        tail.next = (first != null) ? first : second;   // raccord du reste
        // [1,2] + [4,3]  →  1 → 4 → 2 → 3      ✅
    }
}