// Write pseudocode or Java for the Linked List methods that were not covered in the lecture. 
// This could be any of the following: append, prepend, search, get, deleteFirst.

class Node {
    int data;
    Node next;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;
    private Node tail;

    // Constructor to initialize an empty list
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Prepend a new item to the beginning of the list
    public void prepend(int item) {
        Node n = new Node(item); // Create a new node with the given item
        if (this.head == null) { // Empty case
            this.head = n;
            this.tail = n;
        } else {
            n.next = this.head; // Point the new node to the current head
            this.head = n;      // Update the head to the new node
        }
    }

    // Append a new item to the end of the list
    public void append(int item) {
        Node n = new Node(item); // Create a new node with the given item
        n.next = null;           // Set the next pointer to null
        if (this.head == null) { // Empty case
            this.head = n;
            this.tail = n;
        } else {
            this.tail.next = n; // Point the current tail's next to the new node
            this.tail = n;      // Update the tail to the new node
        }
    }

    // Search for a node with the given key
    public Node search(int key) {
        Node current = this.head;
        while (current != null) { // Traverse until the end of the list
            if (current.data == key) {
                return current; // Return the node if found
            }
            current = current.next; // Move to the next node
        }
        return null; // Key not found or list is empty
    }

    // Get the node at a specific index
    public Node getItem(int index) {
        Node current = this.head;
        int pos = 0;
        while (current != null) { // Traverse until the end of the list
            if (pos == index) {
                return current; // Return the node at the specified index
            }
            pos++;
            current = current.next; // Move to the next node
        }
        throw new IndexOutOfBoundsException("Index out of bounds"); // If index is invalid
    }

    // Delete the first node in the list
    public Node deleteFirst() {
        if (this.head == null) { // Empty case
            throw new IllegalStateException("Empty list"); // Raise error
        }
        Node removed = this.head; // Node to remove
        this.head = this.head.next; // Update head to the next node
        if (this.head == null) { // Singleton case
            this.tail = null; // Update tail to null
        }
        return removed; // Return the removed node
    }

    // Print the list for debugging
    public void printList() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Prepend and append items
        list.prepend(10);
        list.prepend(20);
        list.append(30);
        list.append(40);

        // Print the list
        list.printList(); // Output: 20 -> 10 -> 30 -> 40 -> null

        // Search for a key
        Node searchResult = list.search(30);
        System.out.println("Search result: " + (searchResult != null ? searchResult.data : "Not found"));

        // Get item at a specific index
        try {
            Node item = list.getItem(2);
            System.out.println("Item at index 2: " + item.data);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Delete the first node
        Node deleted = list.deleteFirst();
        System.out.println("Deleted first node: " + deleted.data);

        // Print the list after deletion
        list.printList(); // Output: 10 -> 30 -> 40 -> null
    }
}
