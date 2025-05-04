// Implement an algorithm to find the kth to last element of a singly linked list.
// Define k such that passing in k = 1 would return the last element, 
// k = 2 would return to the second to last element, and so on.
public class ReturnKthToLast {
    public static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static Integer returnKthToLast(Node head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        Node current = head;
        int count = 1;
        int secCount = 1;
        
        // count the total number of elements.
        while (current.next != null) {
            count++;
            current = current.next;
        }

        // k is bigger than total number of nodes.
        if (k > count) {
            return null;
        }

        current = head; // current is reset to head
        while (current != null) {
            if (secCount == (count - k + 1)) {
                return current.data;
            }
            secCount++;
            current = current.next;
        }
        return null;
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
        head.next.next.next.next.next = new Node(6); 
        int k = 2;
        
        System.out.println("Original LinkedList: ");
        print(head);

        System.out.println("Element at index " + k + " is: " + returnKthToLast(head, k));
    }
}