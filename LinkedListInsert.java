//  Inserting a Node to a Singly Linked List.
public class LinkedListInsert {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at end
    public static Node insertAtEnd(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) return newNode;

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    // Insert at position (0-based index)
    public static Node insertAtPosition(Node head, int value, int index) {
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Index out of bounds.");
            return head;
        }

        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 3);
        head = insertAtPosition(head, 2, 1);  // Insert 2 at position 1

        System.out.print("Linked list: ");
        printList(head);
    }
}
