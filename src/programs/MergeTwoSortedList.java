package programs;

public class MergeTwoSortedList {

    static Node mergeList(Node list1, Node list2) {
        if(list1==null) {
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        if(list1.value<list2.value) {
            list1.next = mergeList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeList(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        head1.next = node2;
        node2.next = node3;

        Node head2 = new Node(1);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        head2.next = node5;
        node5.next = node6;

        Node head = mergeList(head1, head2);
        while(head!=null) {
            System.out.print(head.value + " --> ");
            head = head.next;
        }
    }

}
