// Use a sigle array to implement three stacks.
import java.util.EmptyStackException;
// Custom exception for full stack
class FullStackException extends RuntimeException {
    public FullStackException() {
        super("Stack is full.");
    }
}

public class FixedMultiStack {
    private final int numberOfStacks = 3;
    private final int stackCapacity;
    private final int[] values;
    private final int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    // Push value onto stack
    public void push(int stackNum, int value) throws FullStackException {
        // check if the stack is full.
        if (isFull(stackNum)) {
            throw new FullStackException();
        }

        /* Increment stack pointer and then update top value. */
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /* Pop item from top stack. */
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) { 
            throw new EmptyStackException();
        }
        
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; // Get top
        values[topIndex] = 0; // Clear
        sizes[stackNum]--; // Shrink
        return value;
    }

    /* Return top element. */
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        return values[indexOfTop(stackNum)];
    }
        
    /* Return if stack is empty. */
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }
    
    /* Return if stack is full. */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }
    
    /* Returns index of the top of the stack. */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public static void main(String[] args) {
        FixedMultiStack stacks = new FixedMultiStack(3); // Each of the 3 stacks has a capacity of 3

        // Push values into different stacks
        stacks.push(0, 10);
        stacks.push(0, 20);
        stacks.push(1, 30);
        stacks.push(2, 40);
        stacks.push(2, 50);
        stacks.push(2, 60);

        // Peek at tops
        System.out.println("Top of Stack 0: " + stacks.peek(0)); // Should be 20
        System.out.println("Top of Stack 1: " + stacks.peek(1)); // Should be 30
        System.out.println("Top of Stack 2: " + stacks.peek(2)); // Should be 60

        // Pop from stacks
        System.out.println("Popped from Stack 2: " + stacks.pop(2)); // Should be 60
        System.out.println("Popped from Stack 0: " + stacks.pop(0)); // Should be 20

        // Peek again
        System.out.println("Top of Stack 0 after pop: " + stacks.peek(0)); // Should be 10
        System.out.println("Top of Stack 2 after pop: " + stacks.peek(2)); // Should be 50
    }
}