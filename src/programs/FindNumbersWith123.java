package programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindNumbersWith123 {

    public static List<Integer> findNumbersWith123(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // Iterate through each number in the array
        for (int num : arr) {
            String numStr = String.valueOf(num); // Convert the number to string
            // Check if the number contains all digits '1', '2', and '3'
            if (numStr.contains("1") && numStr.contains("2") && numStr.contains("3")) {
                result.add(num); // Add the number to the result list if it contains 1, 2, and 3
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {123, 321, 456, 312, 789, 132, 231, 14523};
        List<Integer> numbersWith123 = findNumbersWith123(arr);

        System.out.println("Numbers containing digits 1, 2, and 3: " + numbersWith123);
    }
}
