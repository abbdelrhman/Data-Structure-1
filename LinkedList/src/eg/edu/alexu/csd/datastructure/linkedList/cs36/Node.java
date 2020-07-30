package eg.edu.alexu.csd.datastructure.linkedList.cs36;

public class Node {
     Object data;
     Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }


    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
