package test;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class Runner {

    // List1 = 1->2->4
    // List2 = 1->3->4
    // Result = 1->1->2->3->4->4

    static Node mergeList(Node list1, Node list2) {
        Node curr = new Node(-1);
        Node head = curr;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1!= null) {
            curr.next = list1;
        }

        if(list2!= null) {
            curr.next = list2;
        }

        return head.next;
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
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
