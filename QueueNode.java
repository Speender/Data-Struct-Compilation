import java.util.*;
public class QueueNode {
    Node first;
    Node last;
    int count;
   
    public QueueNode() {
        first = null;
        last = null;
        count = 0;
    }
   
    public boolean isEmpty() {
        return first == null && last == null;
    }
   
    public boolean enqueue(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);  // Use setNext to link the node
            last = newNode;
        }
        count++;
        return true;
    }
   
    public boolean dequeue() {
        if (!isEmpty()) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.getNext();  // Use getNext to get the next node
            }
            count--;
            return true;
        } else {
            return false;
        }
    }
   
    public Object getFirst() {
        if (!isEmpty()) {
            return first.getItem();  // Use getItem to retrieve the value
        } else {
            return null;
        }
    }
   
    public Object getLast() {
        if (!isEmpty()) {
            return last.getItem();  // Use getItem to retrieve the value
        } else {
            return null;
        }
    }
   
    public String toString() {
        String result = "";
        if (!isEmpty()) {
            result += "first = [" + first.getItem() + "]\n";  // Use getItem
            result += "last  = [" + last.getItem() + "]\n";  // Use getItem

            Node temporary = first;
            while (temporary != null) {
                result += "[" + temporary.getItem() + "]->";  // Use getItem
                temporary = temporary.getNext();  // Use getNext
            }
            result += "\n";
        }
        return result;
    }   

    public void display() {
        if (!isEmpty()) {
            Node temporary = first;
            while (temporary != null) {
                System.out.print("[" + temporary.getItem() + "]->");  // Use getItem
                temporary = temporary.getNext();  // Use getNext
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty...");
        }
    }
   
    public static void QueueNodeMen(Scanner scann) {
        String Choice;
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
        
            Choice = scann.nextLine();
        
            switch (Choice) {
                case "1":
                    System.out.print("Enter value to enqueue: ");
                    String value = scann.nextLine();
                    qn.enqueue(value);
                    System.out.println(value + " enqueued to the queue.");
                    break;
                
                case "2":
                    if (qn.dequeue()) {
                        System.out.println("Element dequeued from the queue.");
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                
                case "3":
                    qn.display();
                    break;
                
                case "4":
                    Object first = qn.getFirst();
                    if (first != null) {
                        System.out.println("First element: " + first);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                
                case "5":
                    Object last = qn.getLast();
                    if (last != null) {
                        System.out.println("Last element: " + last);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                
                case "6":
                    if (qn.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                
                case "0":
                    System.out.println("Exiting...");
                    break;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        
        } while (!Choice.equals("0"));
    }
}
