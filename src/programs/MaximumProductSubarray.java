package programs;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Initialize variables to track the maximum and minimum product so far
        int maxProduct = nums[0];
        int minProductSoFar = nums[0];
        int maxProductSoFar = nums[0];

        // Iterate through the array starting from index 1
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // If current number is negative, swap min and max
            if (current < 0) {
                int temp = maxProductSoFar;
                maxProductSoFar = minProductSoFar;
                minProductSoFar = temp;
            }

            // Update maxProductSoFar and minProductSoFar
            maxProductSoFar = Math.max(current, current * maxProductSoFar);
            minProductSoFar = Math.min(current, current * minProductSoFar);

            // Update the global maximum product
            maxProduct = Math.max(maxProduct, maxProductSoFar);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + maxProduct(nums)); // Output: 6

        int[] nums2 = {-2, 0, -1};
        System.out.println("Maximum Product Subarray: " + maxProduct(nums2)); // Output: 0
    }
}