// remove duplicates from an unsorted linked list using a HashSet.
import java.util.HashSet;
import java.util.Set;
public class RemoveDuplicatesLinkedListUsingHashSet {
    public static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void remove(Node head) {
        if (head == null) return;

        Set<Integer> seen = new HashSet<>();
        Node current = head;
        seen.add(current.data);

        while (current.next != null) {
            if (seen.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                seen.add(current.next.data);
                current = current.next;
            }
        }
    }

    public static void print(Node head) {
        Node current = head;

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next.next = new Node(5);

        System.out.println("Original List: ");
        print(head);

        remove(head);
        System.out.println("Modified list after removing duplicates: ");
        print(head);
    }
}
