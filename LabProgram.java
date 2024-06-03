import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class LabProgram {
   
   private static int recursions = 0;
   private static int comparisons = 0;
   // Read and return an ArrayList of integers.
   private static ArrayList<Integer> readNums(Scanner scnr) {
      int size = scnr.nextInt();                // Read size of ArrayList
      ArrayList<Integer> nums = new ArrayList<Integer>();
      for (int i = 0; i < size; ++i) {          // Read the numbers
         nums.add(scnr.nextInt());
      }
      return nums;
   }

   // mid = (high + low) / 2
   // low = mid + 1 or high = mid - 1

   /*
   while (high >= low) {
         mid = (high + low) / 2;
         if (numbers[mid] < key) {
            low = mid + 1;
         } 
         else if (numbers[mid] > key) {
            high = mid - 1;
         } 
         else {
            return mid;
         }
      }

      return -1; // not found
   } 
   */
   static public int binarySearch(int target, ArrayList<Integer> integers,
                                    int lower, int upper) {
      recursions++;
      int mid = (upper + lower) / 2;
      int high = upper;
      int low = lower;

      comparisons++;
      if (integers.get(mid) == target) {
          return mid;
      }

      if (high == low) {
          return -1;
      }

      if (integers.get(mid) < target) {

          comparisons++;

          low = mid + 1;

          return binarySearch(target, integers, low, high);

      } else {

          comparisons++;

          high = mid - 1;

          return binarySearch(target, integers, low, high);
      }
   }

   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      // Input a list of integers
      ArrayList<Integer> integers = readNums(scnr);

      // Input a target value for the search
      int target = scnr.nextInt();

      int index = binarySearch(target, integers, 0, integers.size() - 1);

      System.out.printf("index: %d, recursions: %d, comparisons: %d\n",
                        index, recursions, comparisons);
   }
}
