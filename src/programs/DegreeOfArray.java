package programs;

import java.util.*;

public class DegreeOfArray {
    public static int findShortestSubarrayWithDegree(int[] nums) {
        // Map to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Map to store the first occurrence index of each element
        Map<Integer, Integer> firstIndexMap = new HashMap<>();

        // Map to store the last occurrence index of each element
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        // Populate the maps
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            if (!firstIndexMap.containsKey(num)) {
                firstIndexMap.put(num, i); // Record the first occurrence
            }
            lastIndexMap.put(num, i); // Update the last occurrence
        }

        // Find the degree of the array
        int degree = Collections.max(frequencyMap.values());
        int minLength = Integer.MAX_VALUE;

        // Iterate through the map to find the smallest subarray with the same degree
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == degree) {
                int length = lastIndexMap.get(num) - firstIndexMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println("Smallest subarray length with the same degree: " + findShortestSubarrayWithDegree(nums));

        int[] nums2 = {1, 2, 2, 3, 1, 4, 2};
        System.out.println("Smallest subarray length with the same degree: " + findShortestSubarrayWithDegree(nums2));
    }
}