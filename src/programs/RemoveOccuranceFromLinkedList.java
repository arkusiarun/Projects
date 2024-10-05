package programs;

import java.util.HashSet;
import java.util.Set;

public class RemoveOccuranceFromLinkedList {

    public Node deleteDuplicates(Node head) {
        Node node = head;
        Node prev = null;
        Set<Integer> set = new HashSet();
        while(node!=null) {
            int val = node.value;
            if(set.contains(val)) {
                if(node.next!=null) {
                    prev.next = node.next;
                    node.next = null;
                }
            } else {
                set.add(val);
                prev = node;
            }
            node = prev.next;
        }
        return head;
    }
}