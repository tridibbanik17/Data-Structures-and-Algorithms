// Implement a function to check if a linked list is a palindrome.
public class PalindromeLinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head) {
        Node originalCopy = copyList(head);
        Node reverseCopy = reverseList(copyList(head));
        return areEqual(originalCopy, reverseCopy);
    }

    private static Node copyList(Node head) {
        if (head == null) return null;
        Node aux = new Node(head.data);
        Node currentOriginal =  head.next;
        Node currentNew = aux;

        while (currentOriginal != null) {
            currentNew.next = new Node(currentOriginal.data);
            currentNew = currentNew.next;
            currentOriginal = currentOriginal.next;
        }
        return aux;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node newNode = current.next;
            current.next = prev;
            prev = current;
            current = newNode;
        }

        return prev;
    }

    private static boolean areEqual(Node a, Node b) {
        while (a != null && b != null) {
            if (a.data != b.data) return false;
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

    public static void main(String[] args) {
        Node x = new Node(1);
        x.next = new Node(2);
        x.next.next = new Node(3);
        x.next.next.next = new Node(2);
        x.next.next.next.next = new Node(1); // The final LinkedList becomes, 1 -> 2 -> 3 -> 2 -> 1, which should return true.

        System.out.println("Is it a palindrome? " + isPalindrome(x));
    }
}
