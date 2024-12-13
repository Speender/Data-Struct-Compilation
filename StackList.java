import java.util.Scanner;

public class StackList {
    private StackNode top;
    private int count;

    public StackList() {
        top = null;
        count = 0;
    }

    private boolean isEmpty() {
        // return top == null;
        return count == 0;
    }

    public boolean push(String data) {
        StackNode node = new StackNode(data);
        node.tail = top;
        top = node;
        count++;
        return true;
    }

    public boolean pop() {
        if (!isEmpty()) {
            top = top.tail;
            count--;
            return true;
        }
        return false;
    }

    public String peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public void display() {
        if (!isEmpty()) {
            StackNode temporary = top;
            while (temporary != null) {
                System.out.println(temporary.data);
                temporary = temporary.tail;
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty....");
        }
    }

    public static void StackList(Scanner scan) {
        StackList stack = new StackList();

        int choice;
        do {
            System.out.println("\nStack List Menu:");
            System.out.println("[1] Push to Stack");
            System.out.println("[2] Pop from Stack");
            System.out.println("[3] Peek at Stack");
            System.out.println("[4] Display Stack");
            System.out.println("[0] Exit Stack List Program");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    String value = scan.nextLine();
                    stack.push(value);
                    System.out.println("Pushed " + value + " to the stack.");
                    break;

                case 2:
                    if (stack.pop()) {
                        System.out.println("Successfully popped from the stack.");
                    } else {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;

                case 3:
                    String top = stack.peek();
                    if (top != null) {
                        System.out.println("Top of stack: " + top);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Current Stack:");
                    stack.display();
                    break;

                case 0:
                    System.out.println("Exiting Stack List Program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }
}

class StackNode {
    String data;
    StackNode tail;

    public StackNode(String data) {
        this.data = data;
        this.tail = null;
    }
}
