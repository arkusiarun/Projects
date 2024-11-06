package programs;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // You are in the decreasing part of the array.
                // This means the peak is on the left side (including mid).
                right = mid;
            } else {
                // You are in the increasing part of the array.
                left = mid + 1;
            }
        }

        // When left == right, we have found the peak element.
        return left;
    }
}
