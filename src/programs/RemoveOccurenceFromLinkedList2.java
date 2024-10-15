package programs;

public class RemoveOccurenceFromLinkedList2 {
    public Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node output = new Node(0, head);
        Node pre = output;

        while (head != null) {
            if (head.next != null && head.value == head.next.value) {
                while (head.next != null && head.value == head.next.value) {
                    head = head.next;
                }
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return output.next;
    }
}
