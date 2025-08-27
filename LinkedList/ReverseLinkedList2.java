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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        int j;


        for (j=1; j < left; j++)
        {
            temp = temp.next;
        }

       
        ListNode x = temp;

        
        for (j=left; j <= right; j++) 
        {
            list.add(temp.val);
            temp = temp.next;
        }

       
        temp = x;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp.val = list.get(i);
            temp = temp.next;
        }

        return head;
    }
}