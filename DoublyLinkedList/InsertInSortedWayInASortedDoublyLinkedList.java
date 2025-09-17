/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/

class Solution {
    public Node sortedInsert(Node head, int x) {
        Node newNode = new Node(x);

        if (head == null) return newNode;

        if (x <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode; 
        }

        Node curr = head;
        while (curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }

        Node temp = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
        newNode.next = temp;

        if (temp != null) {
            temp.prev = newNode;
        }

        return head;
    }
}
