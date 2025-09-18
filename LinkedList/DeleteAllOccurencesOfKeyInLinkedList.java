/* Linked list Node
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class GfG {
    public static Node deleteAllOccurances(Node head, int x) {
        // Your code here
        if (head == null) return null;

        
        while (head != null && head.data == x) {
            head = head.next;
        }

        
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data == x) {
                curr.next = curr.next.next; 
            } else {
                curr = curr.next; 
            }
        }

        return head;
    }
}