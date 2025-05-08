// Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
// beginning of the loop.
// DEFINITION
// Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
// as to make a loop in the linked list.
// EXAMPLE
// Input: A -> B -> C -> D -> E -> C [the same C as earlier]
// Output: C
import java.util.HashSet;
import java.util.Set;
public class LoopDetectLinkedListUsingHashSet {
    public static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node detect(Node a) {
        if (a == null) return null;
        Node current = a;
        Set<Node> unique = new HashSet<>();
        while (current != null) {
            if (unique.contains(current)) return current;
            unique.add(current);
            current = current.next;
        }
        return null;
    }

    public static void print(Node head) {
        Set<Node> visited = new HashSet<>();
        Node current = head;
        while (current != null) {
            if (visited.contains(current)) {
                System.out.print(current.data + "->LOOP...");
                break;
            }
            System.out.print(current.data + "->");
            visited.add(current);
            current = current.next;
        }
        if (current == null) {
            System.out.println("null");
        } else {
            System.out.println();
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