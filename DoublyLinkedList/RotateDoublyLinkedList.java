class Solution {
    public Node rotateDLL(Node head, int p) {
        Node tail = head;

        // Find the last node
        while (tail.next != null) {
            tail = tail.next;
        }

        // Make the list circular
        tail.next = head;
        head.prev = tail;

        // Move head and tail by the given position
        for (int count = 1; count <= p; count++) {
            head = head.next;
            tail = tail.next;
        }

        // Break the circular connection
        tail.next = null;
        head.prev = null;

        return head;
    }
}