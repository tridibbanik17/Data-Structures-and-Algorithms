import java.util.EmptyStackException;

// StackADT<T> class provides a generic, singly linked-list-based implementation of a stack.
// pop(): remove the top item from the stack.
// push(item): Add an item to the top of the stack.
// peek(): Return the top of the stack.
// isEmpty(): Return true if and only if the stack is empty.

public class StackADT<T> {
    private static class StackNode<T> {
        private final T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackADT<Integer> stack = new StackADT<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }
}