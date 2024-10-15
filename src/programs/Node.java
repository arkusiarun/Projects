package programs;

public class Node {
    Node next;
    int value;

    public Node(int val) {
        this.value = val;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
