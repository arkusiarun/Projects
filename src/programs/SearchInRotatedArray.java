package programs;

public class SearchInRotatedArray {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) { // Left half is sorted
                // Check if the target is in the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { // Search in the right half
                    left = mid + 1;
                }
            } else { // Right half is sorted
                // Check if the target is in the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else { // Search in the left half
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = search(nums, target);
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found");
        }
    }
}