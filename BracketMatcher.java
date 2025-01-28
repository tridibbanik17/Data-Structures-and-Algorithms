import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BracketMatcher {

    public static boolean matchp(Queue<String> q) {
        // Create a stack to store opening brackets
        Stack<String> stack = new Stack<>();
        
        // Define a map of closing to opening brackets
        String openingBrackets = "([{";
        String closingBrackets = ")]}";

        // Process each token in the queue
        while (!q.isEmpty()) {
            String token = q.poll(); // Dequeue the next token
            
            // If token is an opening bracket, push it onto the stack
            if (openingBrackets.contains(token)) {
                stack.push(token);
            } 
            // If token is a closing bracket, check for matching opening bracket
            else if (closingBrackets.contains(token)) {
                // If the stack is empty, it's an unmatched closing bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top element from the stack
                String top = stack.pop();
                
                // Check if the popped element matches the closing bracket
                if (!isMatchingPair(top, token)) {
                    return false;
                }
            }
            // Ignore non-bracket tokens
        }

        // After processing all tokens, ensure the stack is empty
        return stack.isEmpty();
    }

    // Helper method to check if two brackets are a matching pair
    private static boolean isMatchingPair(String open, String close) {
        return (open.equals("(") && close.equals(")")) ||
               (open.equals("[") && close.equals("]")) ||
               (open.equals("{") && close.equals("}"));
    }

    public static void main(String[] args) {
        // Example usage
        Queue<String> expression = new LinkedList<>();
        expression.add("x");
        expression.add("+");
        expression.add("(");
        expression.add("32");
        expression.add("*");
        expression.add("[");
        expression.add("-");
        expression.add("2");
        expression.add("]");
        expression.add(")");

        System.out.println("Is the expression well-formed? " + matchp(expression)); // Output: true
    }
}
