import java.util.*;

public class NoDuplicate {
   public static void NoDuplicate(Scanner scan){
      int[] num = new int[10];
      String result = "";
      int x;
      int count = 0;
      
      System.out.println("Enter 10 numbers:");
      for(int i = 0; i < 10; i++)
      {
         x = scan.nextInt();
         scan.nextLine();
         if(!isExisting(x, count, num))
         {
            num[count++] = x;
            result += x + "\n";
         }
      }
      
      System.out.println(result);
   }
   
   public static boolean isExisting(int x, int arr_count, int[] arr)
   {
      for(int i = 0; i < arr_count; i++)
      {
         if(x == arr[i])
            return true;
      }
      
      return false;
   }
}
