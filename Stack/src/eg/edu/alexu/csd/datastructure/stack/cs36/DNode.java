package eg.edu.alexu.csd.datastructure.stack.cs36;

public class DNode {
    Object data ;
    DNode next;
    DNode prev ;

    public DNode(Object data) {
        this.data = data;
        this.next=null;
        this.prev = null;
    }

    public DNode(Object data, DNode next, DNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Object getData() {
        return data;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrev() {
        return prev;
    }
}

