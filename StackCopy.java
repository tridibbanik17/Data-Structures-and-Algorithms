import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackCopy {
    
    // Function to copy a stack and return a new stack
    public static Stack<Integer> copy(Stack<Integer> originalStack) {
        // Create a new empty stack
        Stack<Integer> newStack = new Stack<>();
        
        // Create a temporary queue to hold elements
        Queue<Integer> tempQueue = new LinkedList<>();
        
        // Create a temporary stack to preserve the order
        Stack<Integer> tempStack = new Stack<>();
        
        // Step 1: Transfer elements from the original stack to a queue and a temporary stack
        while (!originalStack.isEmpty()) {
            Integer element = originalStack.pop();        // Pop from the original stack
            tempQueue.add(element);                      // Enqueue the element in the tempQueue
            tempStack.push(element);                      // Push the element in tempStack to preserve order
        }
        
        // Step 2: Refill the original stack by transferring elements back from tempStack
        while (!tempStack.isEmpty()) {
            Integer element = tempStack.pop();          // Pop from tempStack
            originalStack.push(element);                // Push it back to the original stack
        }
        
        // Step 3: Transfer elements from the queue to the new stack
        while (!tempQueue.isEmpty()) {
            Integer element = tempQueue.poll();         // Dequeue from tempQueue
            newStack.push(element);                     // Push to the new stack
        }
        
        // Return the new stack, which is a copy of the original stack
        return newStack;
    }

    // Main method to test the copy functionality
    public static void main(String[] args) {
        // Create and populate the original stack
        Stack<Integer> originalStack = new Stack<>();
        originalStack.push(1);
        originalStack.push(2);
        originalStack.push(3);
        
        // Call the copy method to create a new stack
        Stack<Integer> copiedStack = copy(originalStack);
        
        // Display the original stack and the copied stack
        System.out.println("Original Stack: " + originalStack);
        System.out.println("Copied Stack: " + copiedStack);
    }
}

