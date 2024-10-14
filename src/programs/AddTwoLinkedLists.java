package programs;

public class AddTwoLinkedLists {

    public Node addTwoNumbers(Node l1, Node l2) {
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
}
