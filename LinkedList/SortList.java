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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        {
             return head; 
        }
        ListNode q = head, r = head, p = null;
        while (r != null && r.next != null) {
            p = q;
            q = q.next;
            r = r.next.next;
        }
        if (p != null) {   
            p.next = null; 
        }
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(q);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head; 
        if (l1.val < l2.val) {
            head = l1; 
            l1 = l1.next; 
        } else {
            head = l2; 
            l2 = l2.next; 
        }

        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = (l1 != null) ? l1 : l2;

        return head;
    }
}

