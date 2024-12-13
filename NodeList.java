import java.util.Scanner;

public class NodeList {
    private Node last;
    private int counter;

    public NodeList() {
        last = null;
        counter = 0;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public boolean add(int item) {
        Node newNode = new Node(item);
        if (last == null) {
            last = newNode;
        } else {
            Node temp = last;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        counter++;
        return true;
    }

    public boolean delete(int location) {
        if (location < 0 || location >= counter) {
            return false;
        }

        if (location == 0) {
            last = last.getNext();
            counter--;
            return true;
        }

        Node temp = getLastNode(location - 1);
        if (temp == null || temp.getNext() == null) {
            return false;
        }
        temp.setNext(temp.getNext().getNext());
        counter--;
        return true;
    }

    public void display() {
        Node temp = last;
        while (temp != null) {
            System.out.print(temp.getItem() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    private Node getLastNode(int location) {
        Node temp = last;
        for (int i = 0; i < location; i++) {
            if (temp == null) {
                return null;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    public static void NodeList(Scanner scan) {
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
