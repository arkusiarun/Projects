package programs;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        // Min-Heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        // Add elements to the heap
        for (int num : nums) {
            minHeap.offer(num); // Add element to the heap
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("The " + k + "-th largest element is: " + findKthLargest(nums, k));
    }
}
