// Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
// beginning of the loop.
// DEFINITION
// Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
// as to make a loop in the linked list.
// EXAMPLE
// Input: A -> B -> C -> D -> E -> C [the same C as earlier]
// Output: C

public class LoopDetectionLinkedList {
    public static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Detects the start of the loop using Floyd’s algorithm
    public static Node detect(Node head) {
        Node slow = head;
        Node fast = head;

        // Determine if a loop exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }    

        // No loop
        if (fast == null || fast.next == null) return null;   

        // Find the start of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        } 
        // Start of the loop
        return slow;
    }

    public static void print(Node head) {
        Node slow = head;
        Node fast = head;

        // Detect loop first
        boolean hasLoop = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        Node current = head;
        int counter = 0;
        while (current != null && counter < 20) { // prevent infinite loop
            System.out.print(current.data + "->");
            current = current.next;
            counter++;
        }

        if (hasLoop) {
            System.out.println("LOOP...");
        } else {
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Node a = new Node('A');
        a.next = new Node('B');
        Node loopStart = new Node('C');
        a.next.next = loopStart;
        loopStart.next = new Node('D');
        loopStart.next.next = new Node('E');
        loopStart.next.next.next = loopStart;

        System.out.print("LinkedList: ");
        print(a);

        Node detected = detect(a);
        System.out.print("Node that creates a loop is: " + (detected != null? detected.data: "None"));
    }
}
