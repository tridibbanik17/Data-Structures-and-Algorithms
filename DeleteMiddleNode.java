// Implement an algorithm to delete a node in the middle (i.e., any node but
// last node, not necessarily the exact middle) of a singly linked list, given only access to
// that node. Don't pass the head node as mid node.
public class DeleteMiddleNode {
    public static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean delMidNode(Node mid) {
        // Don't delete the last node.
        if (mid == null || mid.next == null) return false; 

        mid.data = mid.next.data;
        mid.next = mid.next.next;
        return true;
    }

    public static void print(Node head) {
        Node current = head;
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list: ");
        print(head);

        Node mid = head.next;
        boolean deleted = delMidNode(mid);
        if (deleted == true) {
            System.out.println("After deleting Node with data: " + mid.data + ", the list becomes: ");
            print(head);
        } else {
            System.out.println("No eligible mid node is found.");
        }
    }
}