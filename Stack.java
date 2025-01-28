import java.util.LinkedList;
import java.util.Queue;

public class Stack<T> {
    private LinkedList<T> stack;

    // Constructor to initialize the stack
    public Stack() {
        stack = new LinkedList<>();
    }

    // Push an item onto the stack
    public void push(T item) {
        stack.addFirst(item);
    }

    // Pop an item from the stack
    public T pop() {
        if (!isEmpty()) {
            return stack.removeFirst();
        }
        throw new RuntimeException("Stack is empty");
    }

    // Peek at the top item of the stack without removing it
    public T peek() {
        if (!isEmpty()) {
            return stack.getFirst();
        }
        throw new RuntimeException("Stack is empty");
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Method to copy the current stack
    public Stack<T> copy() {
        Stack<T> newStack = new Stack<>(); // New stack to return
        Queue<T> tempQueue = new LinkedList<>(); // Temporary queue to hold elements

        // Step 1: Transfer elements from the original stack to the queue
        while (!isEmpty()) {
            T element = pop(); // Remove the top element from the original stack
            tempQueue.add(element); // Add the element to the queue
        }

        // Step 2: Restore the original stack and simultaneously fill the new stack
        while (!tempQueue.isEmpty()) {
            T element = tempQueue.remove(); // Remove an element from the queue
            push(element); // Add the element back to the original stack
            newStack.push(element); // Add the element to the new stack
        }

        return newStack; // Return the copied stack
    }

    // For testing purposes
    public static void main(String[] args) {
        Stack<Integer> originalStack = new Stack<>();
        originalStack.push(1);
        originalStack.push(2);
        originalStack.push(3);

        System.out.println("Original Stack before copying:");
        while (!originalStack.isEmpty()) {
            System.out.print(originalStack.pop() + " ");
        }

        // Copy the stack
        Stack<Integer> copiedStack = originalStack.copy();

        System.out.println("\nCopied Stack:");
        while (!copiedStack.isEmpty()) {
            System.out.print(copiedStack.pop() + " ");
        }

        System.out.println("\nOriginal Stack after copying:");
        while (!originalStack.isEmpty()) {
            System.out.print(originalStack.pop() + " ");
        }
    }
}
