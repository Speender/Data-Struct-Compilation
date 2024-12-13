import java.util.Scanner;

public class SumAndProduct {

    public void calculateSumAndProduct(Scanner scan) {
        int[] values = new int[10];
        int sum = 0, prod = 1;

        System.out.println("Enter 10 integer values:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            values[i] = scan.nextInt();
            if (values[i] > 0) {
                sum += values[i];
                prod *= values[i];
            }
        }

        System.out.println("Total sum of positive numbers: " + sum);
        System.out.println("Total product of positive numbers: " + prod);

        // Clear the newline character from the buffer
        scan.nextLine();
    }
}
