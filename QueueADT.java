import java.util.NoSuchElementException;

// This program implements a generic QueueADT<T> class using a singly linked list.
// enqueue(item): add item to the end of the list
// dequeue(): remove item from the start of the list
// peek(): return the first item in the list
// isEmpty(): return true if and only if the queue is empty

public class QueueADT<T> {
    public static class QueueNode<T> {
        private final T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> start;
    private QueueNode<T> end;
    
    public T dequeue() {
        if (start == null) throw new NoSuchElementException("Queue is empty");
        T item = start.data;
        start = start.next;
        if (start == null) end = null;
        return item;
    }

    public void enqueue(T item) {
        QueueNode<T> t = new QueueNode<>(item);
        if (end != null) end.next = t;
        end = t;
        if (start == null) start = end;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public T peek() {
        if (start == null) throw new NoSuchElementException("Queue is empty");
        T item = start.data;
        return item;
    }

    public static void main(String[] args) {
        QueueADT<String> queue = new QueueADT<>();

        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");

        System.out.println("Front of queue: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
}