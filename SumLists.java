// You have two numbers represented by a linked list, where each node contains a single
// digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
// function that adds the two numbers and returns the sum as a linked list. 
public class SumLists {
    public static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }
    }

    public static LinkedListNode addLists(LinkedListNode a, LinkedListNode b, int carry) {
        if (a == null && b == null && carry == 0) return null;

        int value = carry;
        if (a != null) value += a.data;
        if (b != null) value += b.data;

        LinkedListNode result = new LinkedListNode(value%10);

        result.data = value%10;

        LinkedListNode more = addLists(a == null ? null : a.next, b == null ? null : b.next, value >= 10 ? 1: 0);
        result.setNext(more);
            
        return result;
    }

    public static void print(LinkedListNode a) {
        LinkedListNode current = a;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(2);
        a.setNext(new LinkedListNode(4));
        a.next.setNext(new LinkedListNode(3)); // Represents 342

        LinkedListNode b = new LinkedListNode(5);
        b.setNext(new LinkedListNode(6));
        b.next.setNext(new LinkedListNode(4)); // represents 465

        LinkedListNode result = addLists(a, b, 0);
        print(result); // output should be (342 + 465) = 807, the printed LinkedList would be 7 -> 0 -> 8
    }
}