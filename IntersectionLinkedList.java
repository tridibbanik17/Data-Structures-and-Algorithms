// Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is defined based on reference, not value. That is, if the kth
// node of the first linked list is the exact same node (by reference) as the jth node of the second
// linked list, then they are intersecting. 

public class IntersectionLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node intersect(Node a, Node b) {
        Node currA = a;

        while (currA != null) {
            Node currB = b;
            while (currB != null) {
                if (currB == currA) {
                    return currB;
                }
                currB = currB.next;
            }
            currA = currA.next;
        }
        return null;
    }

    public static void print(Node x) {
        Node current = x;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Shared part of list
        Node shared = new Node(7);
        shared.next = new Node(8);

        // List A
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = shared;

        // List B
        Node b = new Node(4);
        b.next = shared;

        System.out.println("First LinkedList: ");
        print(a);
        System.out.println("Second LinkedList: ");
        print(b);

        Node intersection = intersect(a, b);
        System.out.println("Intersecting node, if any: " + (intersection != null? intersection.data:"None"));
    }
}