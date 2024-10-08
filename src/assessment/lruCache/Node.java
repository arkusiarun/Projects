package assessment.lruCache;

public class Node {
    int value;
    int key;
    Node prev;
    Node next;

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}