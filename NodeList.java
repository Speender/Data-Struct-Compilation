import java.util.Scanner;

public class NodeList {
    private Node head; // Pointer to the first node in the list
    private int counter; // Count of nodes in the list

    public NodeList() {
        head = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean add(int item) {
        Node newNode = new Node(item);

        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the end of the list
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode); // Add the new node at the end
        }

        counter++; // Increment the counter
        return true;
    }

    public boolean delete(int location) {
        if (location < 0 || location >= counter) { // Validate location
            return false;
        }

        if (location == 0) { // Deleting the first node
            head = head.getNext();
            counter--;
            return true;
        }

        // Find the node just before the one to be deleted
        Node temp = getNodeAt(location - 1);
        if (temp == null || temp.getNext() == null) {
            return false;
        }

        temp.setNext(temp.getNext().getNext()); // Skip the node to delete
        counter--;
        return true;
    }

    public void display() {
        Node temp = head; // Start from the head
        while (temp != null) {
            System.out.print(temp.getItem() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    private Node getNodeAt(int location) {
        Node temp = head;
        for (int i = 0; i < location; i++) {
            if (temp == null) {
                return null; // Out of bounds
            }
            temp = temp.getNext();
        }
        return temp;
    }

    public static void NodeListMenu(Scanner scan) {
        NodeList list = new NodeList();
        String choice;

        do {
            System.out.println("\nNode List Menu:");
            System.out.println("[1] Add Node");
            System.out.println("[2] Delete Node");
            System.out.println("[3] Display Nodes");
            System.out.println("[x] Exit Node List Program");
            System.out.print("Enter your choice: ");
            choice = scan.nextLine().trim();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Enter data to add: ");
                        int data = Integer.parseInt(scan.nextLine().trim());
                        list.add(data);
                        System.out.println("Node added.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                    }
                    break;

                case "2":
                    try {
                        System.out.print("Enter index to delete: ");
                        int index = Integer.parseInt(scan.nextLine().trim());
                        if (list.delete(index)) {
                            System.out.println("Node deleted.");
                        } else {
                            System.out.println("Invalid index. Unable to delete node.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid index.");
                    }
                    break;

                case "3":
                    System.out.println("Current Nodes:");
                    if (list.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        list.display();
                    }
                    break;

                case "x":
                case "X":
                    System.out.println("Exiting Node List Program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (!choice.equalsIgnoreCase("x"));
    }
}

class Node {
    private int item; 
    private Node next; 

    public Node(int item) {
        this.item = item;
        this.next = null;
    }

    public int getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
