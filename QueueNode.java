import java.util.Scanner;

class node {
    Object value;
    node next;

    public node(Object value) {
        this.value = value;
        next = null;
    }
}

public class QueueNode {
    node first;
    node last;
    int count;

    public QueueNode() {
        first = null;
        last = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public boolean Enqueue(Object value) {
        node newNode = new node(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        count++;
        return true;
    }

    public boolean Dequeue() {
        if (!isEmpty()) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.next;
            }
            count--;
            return true;
        } else {
            return false;
        }
    }

    public Object getFirst() {
        if (!isEmpty()) {
            return first.value;
        } else {
            return null;
        }
    }

    public Object getLast() {
        if (!isEmpty()) {
            return last.value;
        } else {
            return null;
        }
    }

    public void display() {
        if (!isEmpty()) {
            node temp = first;
            while (temp != null) {
                System.out.print("[" + temp.value + "]-->"); 
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("Queue is Empty...");
        }
    }

    public String toString() {
        String result = "";
        if (!isEmpty()) {
            result += "first = [" + first.value + "]\n";
            result += "last  = [" + last.value + "]\n";

            node temporary = first;
            while (temporary != null) {
                result += "[" + temporary.value + "]->";
                temporary = temporary.next;
            }
            result += "\n";
        }
        return result;
    }

    public static void QueueNodeMenu(Scanner scan) {
        int choice;
        QueueNode qn = new QueueNode();
        do {
            System.out.println("Queue Operations Menu:");
            System.out.println("1. Enqueue an element");
            System.out.println("2. Dequeue an element");
            System.out.println("3. Display queue");
            System.out.println("4. Get the first element");
            System.out.println("5. Get the last element");
            System.out.println("6. Check if the queue is empty");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scan.nextInt();
            scan.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    String value = scan.nextLine();
                    qn.Enqueue(value);
                    System.out.println(value + " enqueued to the queue.");
                    break;
                    
                case 2:
                    if (qn.Dequeue()) {
                        System.out.println("Element dequeued from the queue.");
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                    
                case 3:
                    qn.display();
                    break;
                    
                case 4:
                    Object first = qn.getFirst();
                    if (first != null) {
                        System.out.println("First element: " + first);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                    
                case 5:
                    Object last = qn.getLast();
                    if (last != null) {
                        System.out.println("Last element: " + last);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                    
                case 6:
                    if (qn.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                    
                case 0:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        } while (choice != 0);
    }
}
