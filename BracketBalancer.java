/**
 * Created by vengelmann on 2/19/16.
 */
public class BracketBalancer {

    public static final String OPEN = "open";
    public static final String CLOSE = "close";

    private static class Token {
        public String type;
        public String state;
        public String tokenStr;
    }

    public static void main(String[] args) throws Exception {

        BracketBalancer bb = new BracketBalancer();
        LLStack stack = new LLStack<Token>();

        while (!StdIn.isEmpty()) {

            String tokenStr = StdIn.readString();

            Token currentToken = new Token();
            currentToken.tokenStr = tokenStr;

            currentToken.state = bb.statusOfToken(tokenStr);
            currentToken.type = bb.typeOfToken(tokenStr);

            // Starting expression with close token is illegal.
            if (stack.isEmpty()) {

                if (currentToken.type.equals("close")) {
                    throw new Exception();
                }
                stack.push(currentToken);
            }

            // Only arrive here if the stack is not empty.
            Token prevToken = (Token) stack.lastIn();

            // POP from beginning of stack if previous and current character type match, and previous
            // is OPEN and current is CLOSE
            if (prevToken.state == OPEN && currentToken.state == CLOSE && prevToken.type == currentToken.type) {

                stack.pop();
                // clear out this "stack frame" and move on
                continue;
            }

            // push to beginning of stack if the previous character is an open.
            if (prevToken.state == OPEN) {

                stack.push(currentToken);

            }

            if (prevToken.state == OPEN && currentToken.state == CLOSE && prevToken.type != currentToken.type) {
                System.out.println("Received erroneous close `" + prevToken.tokenStr + " " + currentToken.tokenStr + "'");
                throw new Exception();
            }
        }

    }

    public String statusOfToken(String token) throws Exception {

        String type = "";

        if (token.equals("]")) {
            type = "close";
        } else if (token.equals(")")) {
            type = "close";
        } else if (token.equals("}")) {
            type ="close";
        } else if (token.equals("[")) {
            type = "open";
        } else if (token.equals("(")) {
            type = "open";
        } else if (token.equals("{")) {
            type = "open";
        } else {
            throw new Exception();
        }

        return type;
    }

    public String typeOfToken(String token) throws Exception {

        String type = "";

        if (token.equals("]") || token.equals("[")) {
            type = "bracket";
        } else if (token.equals(")") || token.equals("(")) {
            type = "paren";
        } else if (token.equals("}") || token.equals("{")) {
            type ="squid";
        } else {
            throw new Exception();
        }

        return type;
    }
}
