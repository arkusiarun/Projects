package programs;

public class ReverseLinkedListKGroup {
    public Node reverseKGroup(Node head, int k) {
        if(k==1) {
            return head;
        }
        Node current = head;
        for(int i=0;i<k;i++) {
            if(head!=null) {
                head = head.next;
            } else {
                return current;
            }
        }
        Node nextGroup = reverseKGroup(head, k);
        Node currentStart = current;
        Node prev = current;
        for(int i=0;i<k;i++) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        currentStart.next = nextGroup;
        return prev;
    }
}
