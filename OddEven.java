import java.util.Scanner;

public class OddEven {
    public void displayOddEven(Scanner scan) {
        int[] val = new int[10];
        int[] odd = new int[10];  
        int[] even = new int[10]; 
        int evenCount = 0, oddCount = 0;

        System.out.println("Enter 10 integer values:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            val[i] = scan.nextInt();
            scan.nextLine();
        }

        for (int i = 0; i < 10; i++) {
            if (val[i] % 2 == 0) {
                even[evenCount] = val[i];
                evenCount++;
            } else {
                odd[oddCount] = val[i];
                oddCount++;
            }
        }

        System.out.println("Even\tOdd");

        for (int k = 0; k < 10; k++) { 
            if (k < evenCount) {
                System.out.print(even[k]);
            } 

            if (k < oddCount) { 
                System.out.print("\t\t" + odd[k]);
            }
            System.out.println();
        }
    }
}
