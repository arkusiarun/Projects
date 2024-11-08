package programs;

public class ReverseLinkedList {

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static Node reverseLinkedListRecusrion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node reversedList = reverseLinkedListRecusrion(head.next);
        head.next.next = head;
        head.next = null;
        return reversedList;
    }
}
