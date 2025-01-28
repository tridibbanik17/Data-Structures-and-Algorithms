// Write pseudocode or Java for a client function called postfix_evaluation(expression) that uses a
// stack to evaluate postfix expressions. To simplify, assume the input string is correctly formatted.

import java.util.Stack;

public class PostfixEvaluator {

    public static int postfix_eval(String e) {
        if (e == null || e.isEmpty()) {
            return 0; // Return 0 for empty input
        }

        Stack<Integer> s = new Stack<>();

        // Traverse through each character in the expression
        for (char c : e.toCharArray()) {
            if (Character.isDigit(c)) { // If the character is a digit
                s.push(c - '0'); // Convert char to integer and push to stack
            } else { // Operator case
                if (s.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                int op2 = s.pop(); // Second operand
                int op1 = s.pop(); // First operand

                // Perform the operation based on the operator
                switch (c) {
                    case '+':
                        s.push(op1 + op2);
                        break;
                    case '-':
                        s.push(op1 - op2);
                        break;
                    case '*':
                        s.push(op1 * op2);
                        break;
                    case '/':
                        if (op2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        s.push(op1 / op2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + c);
                }
            }
        }

        if (s.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return s.pop(); // Return the final result
    }

    public static void main(String[] args) {
        // Test cases
        String expression1 = "53+62/*35*+";
        String expression2 = "82/4*3-";

        System.out.println("Postfix Evaluation of '" + expression1 + "': " + postfix_eval(expression1)); // Output: 39
        System.out.println("Postfix Evaluation of '" + expression2 + "': " + postfix_eval(expression2)); // Output: 9
    }
}
