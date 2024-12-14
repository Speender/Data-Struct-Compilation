import java.util.*;

public class MainMenu {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        String choice = "";

        while (true) {
            System.out.print(
                "======================COMPILATION MENU======================\n"+
                "[1] Sum and product program\n" +
                "[2] Odd and Even program\n" +
                "[3] Largest to Smallest program\n" +
                "[4] No Duplicate Program\n" +
                "[5] Stack Array Program\n" +
                "[6] Stack List Program\n" +
                "[7] Node List program\n" +
                "[8] Queue Array program\n" +
                "[9] Queue Node program\n" +
                "[0] Exit Main Menu\n" +
                "=============================================================\nChoice: "
            );

            choice = scan.nextLine();

            switch (choice) {
               case "1":
                   SumAndProduct sap = new SumAndProduct();
                   sap.calculateSumAndProduct(scan);
                   break;
               case "2":
                   OddEven oe = new OddEven();
                   oe.displayOddEven(scan);
                   break;
               case "3":
                    LargestToSmallest lts = new LargestToSmallest();
                    lts.Largest(scan);
                   break;
               case "4":
                    NoDuplicate nd = new NoDuplicate();
                    nd.NoDuplicate(scan);
                    break;
               case "5":
                    StackArray s = new StackArray();
                    s.StackArray(scan);
                    break;
               case "6":
                    StackList sl = new StackList();
                    sl.StackListMenu(scan);
                    break;
               case "7":
                    NodeList nl = new NodeList();
                    nl.NodeListMenu(scan);
                    break;
               case "8":
                    QueueArray.exeQueueMenu(scan);
                    break;
               case "9":
                     QueueNode.QueueNodeMenu(scan);
                    break;
                case "0":
                    System.out.println("Exiting the program. Goodbye!");
                    scan.close(); 
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
