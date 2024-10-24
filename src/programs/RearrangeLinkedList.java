package programs;

public class RearrangeLinkedList {

    public static Node rearrangeLinkedList(Node head) {
        // Dummy nodes for the two partitions
        Node negativeHead = new Node(0);
        Node positiveHead = new Node(0);

        // Pointers to build the two lists
        Node negative = negativeHead;
        Node positive = positiveHead;

        while (head != null) {
            if (head.value < 0) {
                negative.next = head;
                negative = negative.next;
            } else {
                positive.next = head;
                positive = positive.next;
            }
            head = head.next;
        }

        negative.next = positiveHead.next;
        positive.next = null;

        return negativeHead.next;
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

        Node rearrangedHead = (head);
        System.out.println("Rearranged Linked List:");
        printList(rearrangedHead);
    }
}