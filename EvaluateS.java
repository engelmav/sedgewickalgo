/******************************************************************************
 *  Compilation:  javac Evaluate.java
 *  Execution:    java Evaluate
 *  Dependencies: Stack.java
 *
 *  Evaluates (fully parenthesized) arithmetic expressions using
 *  Dijkstra's two-stack algorithm.
 *
 *  % java Evaluate 
 *  ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) 
 *  101.0 
 *
 *  % java Evaulate
 *  ( ( 1 + sqrt ( 5 ) ) / 2.0 ) 
 *  1.618033988749895
 *
 *
 *  Note: the operators, operands, and parentheses must be
 *  separated by whitespace. Also, each operation must
 *  be enclosed in parentheses. For example, you must write
 *  ( 1 + ( 2 + 3 ) ) instead of ( 1 + 2 + 3 ).
 *  See EvaluateDeluxe.java for a fancier version.
 *
 *
 *  Remarkably, Dijkstra's algorithm computes the same
 *  answer if we put each operator *after* its two operands
 *  instead of *between* them.
 *
 *  % java Evaluate
 *  ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + ) 
 *  101.0
 *
 *  Moreover, in such expressions, all parentheses are redundant!
 *  Removing them yields an expression known as a postfix expression.
 *  1 2 3 + 4 5 * * + 
 *
 *
 ******************************************************************************/
import java.util.Stack;
public class EvaluateS {
    public static void main(String[] args) {
        Stack<String> ops  = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if      (s.equals("("))    System.out.println("Ignoring left paren");
            else if (s.equals("+")){
                logOperatorAction(s);
                ops.push(s);
            }
            else if (s.equals("-")){
                logOperatorAction(s);
                ops.push(s);
            }
            else if (s.equals("*")){
                logOperatorAction(s);
                ops.push(s);
            }
            else if (s.equals("/")){
                logOperatorAction(s);
                ops.push(s);
            }
            else if (s.equals("sqrt")){
                logOperatorAction(s);
                ops.push(s);
            }
            else if (s.equals(")")) {
                String op = ops.pop();
                System.out.println("Popping operator " + s);
                double v = vals.pop();
                System.out.println("Popping operand " + String.valueOf(v));
                if      (op.equals("+"))    v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }

    public static void logOperatorAction(String s){
        System.out.println("Pushing " + s + " to operator stack.");
    }

    public static void logOperandAction(String s){
        System.out.println("Pushing " + s + " to operand stack.");
    }
}

