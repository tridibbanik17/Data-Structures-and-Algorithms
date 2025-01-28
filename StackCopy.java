import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackCopy<T> {
    private Stack<T> originalStack;

    // Constructor to initialize the stack
    public StackCopy() {
        originalStack = new Stack<>();
    }

    // Push method for the stack
    public void push(T element) {
        originalStack.push(element);
    }

    // Pop method for the stack
    public T pop() {
        return originalStack.pop();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return originalStack.isEmpty();
    }

    // Copy method
    public Stack<T> copy() {
        Stack<T> newStack = new Stack<>(); // New stack for the copy
        Queue<T> tempQueue = new LinkedList<>(); // Temporary queue
        Stack<T> tempStack = new Stack<>(); // Temporary stack to preserve order

        // Step 1: Transfer elements from originalStack to tempQueue
        while (!originalStack.isEmpty()) {
            T element = originalStack.pop();
            tempQueue.add(element);
            tempStack.push(element);
        }

        // Step 2: Restore the original stack
        while (!tempStack.isEmpty()) {
            T element = tempStack.pop();
            originalStack.push(element);
        }

        // Step 3: Transfer elements from tempQueue to newStack
        while (!tempQueue.isEmpty()) {
            T element = tempQueue.poll();
            newStack.push(element);
        }

        return newStack;
    }

    // Display stack contents
    public void displayStack() {
        System.out.println(originalStack);
    }

    public static void main(String[] args) {
        // Example usage
        StackCopy<Integer> stackWithCopy = new StackCopy<>();
        stackWithCopy.push(1);
        stackWithCopy.push(2);
        stackWithCopy.push(3);

        System.out.println("Original Stack:");
        stackWithCopy.displayStack();

        Stack<Integer> copiedStack = stackWithCopy.copy();

        System.out.println("Original Stack after copy:");
        stackWithCopy.displayStack();

        System.out.println("Copied Stack:");
        System.out.println(copiedStack);
    }
}
