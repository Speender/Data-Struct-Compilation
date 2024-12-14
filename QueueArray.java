import java.util.Scanner;

public class QueueArray {
   private Object[] items;
   private int count;

   public QueueArray(int size) {
      items = new Object[size];
      count = 0;
   }
   
   public boolean isEmpty() {
      return count == 0;
   }
   
   public boolean isFull() {
      return count == items.length;
   }
   
   public boolean enqueue(Object val) {
      if (!isFull()) {
         items[count++] = val;
         return true;
      }
      return false;
   }
   
   public boolean dequeue() {
      if (!isEmpty()) {
         for (int i = 0; i < count - 1; i++) { // Prevent out-of-bounds error
            items[i] = items[i + 1];
         }
         items[count - 1] = null; // Clear the last element
         count--; // Update count
         return true;
      }
      return false;
   }
   
   public Object front() {
      if (!isEmpty()) {
         return items[0];
      }
      return null;
   }
   
   public void display() {
      if (!isEmpty()) {
         for (int i = 0; i < count; i++) {
            System.out.print("[" + items[i] + "]");
            System.out.print(" <-- ");
         }
         System.out.println();
      } else {
         System.out.println("Queue is empty...");
      }
   }

   public static void exeQueueMenu(Scanner scan) {
      int choice;

      System.out.print("Enter the size of the Queue: ");
      int newSize = scan.nextInt();
      scan.nextLine();

      QueueArray qa = new QueueArray(newSize);

      do {
         System.out.println("\nQueue Array Menu:");
         System.out.println("[1] Enqueue");
         System.out.println("[2] Dequeue");
         System.out.println("[3] Display Front");
         System.out.println("[4] Display Queue");
         System.out.println("[5] Exit");
         System.out.print("Choose an option: ");
         choice = scan.nextInt();
         scan.nextLine();

         switch (choice) {
             case 1:
                 System.out.print("Enter value to enqueue: ");
                 String val = scan.nextLine();
                 if (qa.enqueue(val)) {
                     System.out.println("Enqueued: " + val);
                 } else {
                     System.out.println("Queue is full. Cannot enqueue.");
                 }
                 break;
             case 2:
                 if (!qa.isEmpty()) {
                     qa.dequeue();
                     System.out.println("Dequeued front element.");
                 } else {
                     System.out.println("Queue is empty. Cannot dequeue.");
                 }
                 break;
             case 3:
                 System.out.println("Front: " + qa.front());
                 break;
             case 4:
                 qa.display();
                 break;
             case 5:
                 System.out.println("Exiting Queue program...");
                 break;
             default:
                 System.out.println("Invalid option. Please try again.");
         }
      } while (choice != 5);
   }
}
