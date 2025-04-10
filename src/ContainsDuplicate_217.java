import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate_217 {

    public static void main(String[] args) {
        var nums = new int[]{6, 9, 7, 6, 5};
        // Bruteforce technique: looping through all the value:  On^2
        // Sorting the array and check immediate value :  Olog(n)
        // Hashset technique
        System.out.println(containsDuplicateStream(nums));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store unique elements
        Set<Integer> seen = new HashSet<>();
        // Iterate through the array
        for (int num : nums) {
            // If the element is already in the set, it's a duplicate
            if (seen.contains(num)) {
                return true;
            }
            // Otherwise, add it to the set
            seen.add(num);
        }

        // No duplicates found
        return false;
    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    public static boolean containsDuplicateBySorting(int[] nums) {
        Arrays.sort(nums); // Sort the array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // Time Complexity: O(n²)
    // Space Complexity: O(1)
    public static boolean ContainsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean containsDuplicateStream(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.size() != nums.length;
    }
}
