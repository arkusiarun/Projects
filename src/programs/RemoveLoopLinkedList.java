package programs;

public class RemoveLoopLinkedList {

    public void removeLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect the loop
        boolean hasLoop = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        // Step 2: If there is a loop, find the start of the loop
        if (hasLoop) {
            slow = head;

            // If the loop starts from the head
            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            } else {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            // Step 3: Break the loop
            fast.next = null;
        }
    }
}
