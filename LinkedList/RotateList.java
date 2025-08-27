/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

    
        int length = 1;
        ListNode end = head;
        while (end.next != null) {
            length++;
            end = end.next;
        }

       
        k = k % length;

        if (k == 0) return head;

        
        int cut = length - k;
        ListNode current = head;
        for (int i = 1; i < cut; i++) {
            current = current.next;
        }

       
        ListNode start = current.next;
        current.next = null;
        end.next = head;

        return start;
    }
}
    