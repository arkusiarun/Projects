package programs;

public class InfiniteStreamExponentialSearch {

    // Exponential Search: Find the target in an infinite stream using exponential search
    public boolean exponentialSearch(int target) {
        int index = 0;

        // First, find a range where the target might be located by exponentially increasing the index
        while (true) {
            int currentElement = getElementAt(index);
            if (currentElement == target) {
                return true; // Element found
            } else if (currentElement > target) {
                break; // Target is not present in the current range
            }

            // Move to the next exponentially increasing index
            index = index == 0 ? 1 : index * 2; // 1, 2, 4, 8, 16, etc.
        }

        // Now we perform binary search within the found range
        return binarySearch(index / 2, index, target);
    }

    // Simulate an infinite stream by returning a value at the given index.
    private int getElementAt(int index) {
        // Simulate the stream here
        // For example, it could be a sequence or a random number generator.
        return (int) (Math.random() * 100); // Random value between 0-99
    }

    // Binary search in the range [low, high] for the target.
    private boolean binarySearch(int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentElement = getElementAt(mid);

            if (currentElement == target) {
                return true;  // Element found
            } else if (currentElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;  // Target not found
    }

    public static void main(String[] args) {
        InfiniteStreamExponentialSearch searcher = new InfiniteStreamExponentialSearch();

        // Let's say we are searching for 42 in the infinite stream
        int target = 2;
        boolean found = searcher.exponentialSearch(target);

        System.out.println("Found " + target + ": " + found);
    }
}