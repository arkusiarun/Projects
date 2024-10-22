package programs;

import java.util.HashSet;
import java.util.Set;


public class BidPairs {

    public static int countDistinctPairs(int[] bids, int k) {
        Set<Integer> bidSet = new HashSet<>();
        Set<String> distinctPairs = new HashSet<>();

        // Add all bids to the set for O(1) lookups
        for (int bid : bids) {
            bidSet.add(bid);
        }

        // Iterate through each bid and check for pairs with the given difference
        for (int bid : bids) {
            // Check if bid + k exists in the set
            if (bidSet.contains(bid + k)) {
                // To ensure distinct pairs, we can store the pair in a sorted order
                distinctPairs.add(Math.min(bid, bid + k) + "," + Math.max(bid, bid + k));
            }
            // Check if bid - k exists in the set
            if (bidSet.contains(bid - k)) {
                distinctPairs.add(Math.min(bid, bid - k) + "," + Math.max(bid, bid - k));
            }
        }

        // The number of distinct pairs found
        return distinctPairs.size();
    }

    public static void main(String[] args) {
        int[] bids = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println("Number of distinct pairs with difference " + k + ": " + countDistinctPairs(bids, k));
    }
}