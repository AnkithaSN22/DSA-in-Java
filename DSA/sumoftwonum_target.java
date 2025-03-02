package dsa_java25;
import java.util.*;
public class sumoftwonum_target {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];

        // Taking input for array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Taking input for target value
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        sc.close(); // Closing Scanner to prevent resource leak

        // Creating object and calling the function
        sumoftwonum_target obj = new sumoftwonum_target();
        int[] result = obj.twoSum(nums, target);

        // Printing the output
        if (result.length == 2) {
            System.out.println("Indices: " + Arrays.toString(result));
        } else {
            System.out.println("No valid pair found.");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}	

