// Write the pseudocode or Java for insert(i, item) for a doubly linked list. This operation inserts
// item at location i in the list.

class Node {
    int data;
    Node next;
    Node previous;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Constructor to initialize an empty list
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Insert a node at index i with the given item
    public void insert(int i, int item) {
        Node node = new Node(item); // Create a new node
        if (i < 0) { // Negative indices are not valid
            throw new IllegalArgumentException("Index cannot be negative");
        }

        if (i == 0) { // Insert at the head
            if (this.head == null) { // Empty list
                this.head = node;
                this.tail = node;
            } else { // Non-empty list
                node.next = this.head;
                this.head.previous = node;
                this.head = node;
            }
            return;
        }

        // Traverse to find position i
        Node current = this.head;
        for (int index = 0; index < i; index++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.next;
        }

        if (current == null) { // Insertion at the tail
            node.previous = this.tail;
            this.tail.next = node;
            this.tail = node;
        } else { // Insertion in the middle
            node.next = current;
            node.previous = current.previous;
            if (current.previous != null) {
                current.previous.next = node;
            }
            current.previous = node;
        }
    }

    // Print the list for debugging
    public void printList() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert items into the list
        list.insert(0, 10); // Insert at head
        list.insert(1, 20); // Insert at tail
        list.insert(1, 15); // Insert in the middle
        list.insert(3, 30); // Insert at tail

        System.out.println("List after insertions:");
        list.printList(); // Output: 10 <-> 15 <-> 20 <-> 30 <-> null

        try {
            list.insert(10, 40); // Invalid index
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
