package programs;

public class SingleElementInSortedArray {
    public static int findSingleElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if mid is at a pair start or end
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 2; // Single element is after this pair
                } else {
                    high = mid; // Single element is before or at mid
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1; // Single element is after this pair
                } else {
                    high = mid; // Single element is before or at mid
                }
            }
        }

        return nums[low]; // Low and high converge to the single element
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Single element is: " + findSingleElement(nums));
    }
}