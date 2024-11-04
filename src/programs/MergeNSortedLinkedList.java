package programs;

import java.util.PriorityQueue;

public class MergeNSortedLinkedList {

    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a min-heap (priority queue) to store the nodes, sorted by value
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Add the head of each list to the heap
        for (Node list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // Dummy node to help with constructing the final merged list
        Node dummy = new Node(0);
        Node current = dummy;

        // While the heap is not empty, extract the smallest node and add it to the merged list
        while (!minHeap.isEmpty()) {
            Node smallestNode = minHeap.poll();
            current.next = smallestNode; // Add the smallest node to the merged list
            current = current.next;

            // If the smallest node has a next node, add it to the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }

        return dummy.next; // Return the head of the merged list
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example: 3 sorted lists
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        Node[] lists = {list1, list2, list3};

        // Merge the sorted lists
        Node mergedList = mergeKLists(lists);

        System.out.println("Merged Sorted List:");
        printList(mergedList);
    }
}