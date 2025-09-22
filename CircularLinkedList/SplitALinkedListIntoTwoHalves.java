/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public Pair<Node, Node> splitList(Node head) {
        // Code here
          if (head == null || head.next == head) return new Pair<>(head, null);

        Node slow = head, fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next.next == head) fast = fast.next;

        Node head1 = head;
        Node head2 = slow.next;

        slow.next = head1;
        fast.next = head2;

        return new Pair<>(head1, head2);
    }
}