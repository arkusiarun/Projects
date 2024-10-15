package programs;

public class AddTwoLinkedLists {

    static Node addTwoNumbers(Node l1, Node l2) {
        Node temp = new Node(0);
        Node result = temp;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum = sum + l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.value;
                l2 = l2.next;
            }
            sum = sum + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new Node(sum);
            temp = temp.next;
        }

        if (carry != 0) {
            temp.next = new Node(carry);
            temp = temp.next;
        }
        return result.next;
    }

    public  static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        node4.next = node5;
        node5.next = node6;

        addTwoNumbers(node1, node4);

    }
}
