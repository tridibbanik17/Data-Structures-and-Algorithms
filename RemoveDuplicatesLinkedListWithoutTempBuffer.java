// remove duplicates from an unsorted linked list.
// This approach shown below using two pointers doesn't use a temporary buffer like HashSet.
public class RemoveDuplicatesLinkedListWithoutTempBuffer {
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

        Node current = head;

        while (current != null) {
            Node nextNode = current;

            while (nextNode.next != null) {
                if (current.data == nextNode.next.data) {
                    nextNode.next = nextNode.next.next;
                } else {
                    nextNode = nextNode.next;
                }
            }

            current = current.next;
        }
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
