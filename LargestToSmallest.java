import java.util.Scanner;

public class LargestToSmallest {
    public void Largest(Scanner scan) {

        System.out.println("Enter 3 Numbers: ");
        int num1 = scan.nextInt();
        scan.nextLine(); 
        int num2 = scan.nextInt();
        scan.nextLine();
        int num3 = scan.nextInt();
        scan.nextLine();

        int largest = calculateLargest(num1, num2, num3);

        System.out.println("The largest number is: " + largest);
    }

    public int calculateLargest(int num1, int num2, int num3) {
        int largest = num1;

        if (num2 > largest) {
            largest = num2;
        }

        if (num3 > largest) {
            largest = num3;
        }

        return largest;
    }
}
