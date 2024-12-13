import java.util.*;

class StackNode {
    String data;
    StackNode tail;

    public StackNode(String data) {
        this.data = data;
        tail = null;
    } 
}

class StackList {
    private StackNode top;
    private int count;

    public StackList() {
        top = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean push(String data) {
        StackNode node = new StackNode(data);
        node.tail = top;
        top = node;
        count++;
        return true;
    }

    public String pop() {
        if (!isEmpty()) {
            String data = top.data;
            top = top.tail;
            count--;
            return data;
        }
        return null;
    }

    public String peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    public int getcount() {
        return count;
    }
}

public class InfixtoPostfix {
    private String infix;

    public InfixtoPostfix(String data) {
        infix = data;
    }

    private int getPrec(char c) {
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    public String convert() {
        StackList s = new StackList();
        String result = "";

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                result += c;
            } else if (c == '(') {
                s.push(c + "");
            } else if (c == ')') {
                while (!s.isEmpty() && !s.peek().equals("(")) {
                    result += s.pop();
                }
                s.pop();
            } else {
                while (!s.isEmpty() && getPrec(c) <= getPrec(s.peek().charAt(0))) {
                    result += s.pop();
                }
                s.push(c + "");
            }
        }
        while (!s.isEmpty()) {
            result += s.pop();
        }
        return result;
    }

    public static double evaluatePostfix(String postfix) {
        StackList s = new StackList();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                s.push(c + "");
            } else {
                double val2 = Double.parseDouble(s.pop());
                double val1 = Double.parseDouble(s.pop());
                double result = 0;

                switch (c) {
                    case '+':
                        result = val1 + val2;
                        break;
                    case '-':
                        result = val1 - val2;
                        break;
                    case '*':
                        result = val1 * val2;
                        break;
                    case '/':
                        result = val1 / val2;
                        break;
                }
                s.push(result + "");
            }
        }
        return Double.parseDouble(s.pop());
    }

    public static void InfixToPostfixMenu(Scanner scan) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String lastInfix = "";

        do {
            System.out.println("Menu:");
            System.out.println("[1] Convert infix to postfix");
            System.out.println("[2] Evaluate last inputted infix expression");
            System.out.println("[3] Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter infix expression: ");
                    lastInfix = scanner.nextLine();
                    InfixtoPostfix converter = new InfixtoPostfix(lastInfix);
                    String postfix = converter.convert();
                    System.out.println("Postfix: " + postfix);
                    break;
                case 2:
                    if (lastInfix.isEmpty()) {
                        System.out.println("No infix expression has been entered yet.");
                    } else {
                        InfixtoPostfix converterForEvaluation = new InfixtoPostfix(lastInfix);
                        String postfixForEvaluation = converterForEvaluation.convert();
                        double result = evaluatePostfix(postfixForEvaluation);
                        System.out.println("Calculated Result: " + result);
                    }
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
            System.out.println();
        } while (choice != 3);

        scanner.close();
    }
}
