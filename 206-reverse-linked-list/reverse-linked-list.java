class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head; // Base case: end of list
        
        ListNode newHead = reverseList(head.next); // Recurse to the end
        head.next.next = head; // Point next node back to current node
        head.next = null;      // Disconnect old forward link
        
        return newHead; // Pass the new head back up
    }
}