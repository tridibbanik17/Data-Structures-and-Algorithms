//Write pseudocode or Java for a delete(key) linked list method that searches for a given key and
// removes it. If the list contains multiple matching items, remove the first one only.

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

    // Append a new item to the end of the list
    public void append(int item) {
        Node n = new Node(item);
        if (this.head == null) { // Empty case
            this.head = n;
            this.tail = n;
        } else {
            this.tail.next = n;
            this.tail = n;
        }
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

    // Delete the first occurrence of a node with the specified key
    public boolean delete(int key) {
        Node current = this.head;
        Node previous = null;

        // Traverse the list
        while (current != null) {
            if (current.data == key) { // Key found
                if (previous == null) { // The node to delete is the head
                    this.head = current.next; // Update the head
                    if (this.head == null) { // If the list is now empty
                        this.tail = null; // Update the tail to null
                    }
                } else if (current == this.tail) { // The node to delete is the tail
                    this.tail = previous; // Update the tail to the previous node
                    previous.next = null; // Remove the last node
                } else { // The node to delete is in the middle
                    previous.next = current.next; // Bypass the current node
                }
                return true; // Key found and deleted
            }
            previous = current; // Move previous to current
            current = current.next; // Move current to the next node
        }

        return false; // Key not found
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Append items to the list
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        System.out.println("Original List:");
        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> null

        System.out.println("Delete 20:");
        boolean deleted = list.delete(20);
        System.out.println("Deleted: " + deleted);
        list.printList(); // Output: 10 -> 30 -> 40 -> null

        System.out.println("Delete 10 (head):");
        deleted = list.delete(10);
        System.out.println("Deleted: " + deleted);
        list.printList(); // Output: 30 -> 40 -> null

        System.out.println("Delete 40 (tail):");
        deleted = list.delete(40);
        System.out.println("Deleted: " + deleted);
        list.printList(); // Output: 30 -> null

        System.out.println("Delete 50 (not in list):");
        deleted = list.delete(50);
        System.out.println("Deleted: " + deleted);
        list.printList(); // Output: 30 -> null
    }
}
