package programs;

public class RearrangeLinkedList {

    public static Node rearrange(Node head) {
        if (head == null) return null;

        Node negHead = null, negTail = null; // Head and tail for negative list
        Node posHead = null, posTail = null; // Head and tail for positive list

        // Separate negative and positive nodes
        while (head != null) {
            if (head.value < 0) {
                // Add to negative list
                if (negHead == null) {
                    negHead = negTail = head;
                } else {
                    negTail.next = head;
                    negTail = negTail.next;
                }
            } else {
                // Add to positive list
                if (posHead == null) {
                    posHead = posTail = head;
                } else {
                    posTail.next = head;
                    posTail = posTail.next;
                }
            }
            head = head.next;
        }

        // Ensure the end of each list points to null
        if (negTail != null) negTail.next = null;
        if (posTail != null) posTail.next = null;

        // Merge the two lists
        Node resultHead = null, resultTail = null;
        boolean takeNeg = true;

        while (negHead != null || posHead != null) {
            if (takeNeg && negHead != null) {
                if (resultHead == null) {
                    resultHead = resultTail = negHead;
                } else {
                    resultTail.next = negHead;
                    resultTail = resultTail.next;
                }
                negHead = negHead.next;
                takeNeg = false; // Next should take positive
            } else if (!takeNeg && posHead != null) {
                if (resultHead == null) {
                    resultHead = resultTail = posHead;
                } else {
                    resultTail.next = posHead;
                    resultTail = resultTail.next;
                }
                posHead = posHead.next;
                takeNeg = true; // Next should take negative
            } else {
                // If one list is exhausted, we stop
                break;
            }
        }

        // Make sure the final node points to null
        if (resultTail != null) resultTail.next = null;

        return resultHead;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example linked list: 3 -> -1 -> 4 -> -2 -> -5 -> 1 -> -3 -> 2
        Node head = new Node(3);
        head.next = new Node(-1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(-2);
        head.next.next.next.next = new Node(-5);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(-3);
        head.next.next.next.next.next.next.next = new Node(2);

        System.out.println("Original Linked List:");
        printList(head);

        Node rearrangedHead = rearrange(head);
        System.out.println("Rearranged Linked List:");
        printList(rearrangedHead);
    }
}