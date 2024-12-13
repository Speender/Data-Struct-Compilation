import java.util.*;

public class StackArray {
    private String[] s;
    private int count;

    public StackArray(int size) {
        s = new String[size];
        count = 0;
    }

    public StackArray() {
        this(10);
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == s.length;
    }

    public boolean push(String val) {
        if (!isFull()) {
            s[count++] = val;
            return true;
        }
        return false;
    }

    public boolean pop() {
        if (!isEmpty()) {
            s[--count] = null;
            return true;
        }
        return false;
    }

    public String peek() {
        if (!isEmpty()) {
            return s[count - 1];
        }
        return null;
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = count - 1; i >= 0; i--) { 
                System.out.println("[" + s[i] + "]");
            }
        } else {
            System.out.println("Stack is empty");
        }
    }

    public static void StackArray(Scanner scan) {
        System.out.print("Enter the size of the stack: ");
        int size = scan.nextInt();
        scan.nextLine();

        StackArray stack = new StackArray(size);

        String choice;
        do {
            System.out.println("\nStack Array Menu:");
            System.out.println("[1] Push to Stack");
            System.out.println("[2] Pop from Stack");
            System.out.println("[3] Peek at Stack");
            System.out.println("[4] Display Stack");
            System.out.println("[x] Exit Stack Array Program");
            System.out.print("Enter your choice: ");
            choice = scan.nextLine();

            switch (choice) {
                case "1":
                    if (!stack.isFull()) {
                        System.out.print("Enter value to push: ");
                        String value = scan.nextLine();
                        stack.push(value);
                    } else {
                        System.out.println("Stack is full. Cannot push.");
                    }
                    break;

                case "2":
                    if (stack.pop()) {
                        System.out.println("Successfully popped from stack.");
                    } else {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;

                case "3":
                    String top = stack.peek();
                    if (top != null) {
                        System.out.println("Top of stack: " + top);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case "4":
                    System.out.println("Current Stack:");
                    stack.display();
                    break;

                case "x":
                case "X":
                    System.out.println("Exiting Stack Array Program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (!choice.equalsIgnoreCase("x"));
    }
}
