package eg.edu.alexu.csd.datastructure.stack.cs36;

public class Stack implements IStack {
    private DNode head;
    private DNode tail;


    @Override
    public Object pop() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("empty stack");
        }
        // we have one element in the stack
        if(this.size() == 1){
            Object o = this.head.data;
            this.head=null;
            this.tail=null;
            return o;
        }
        Object o = this.tail.data;
        this.tail.prev.next = null;
        this.tail=this.tail.prev;
        return o ;
    }

    @Override
    public Object peek() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.tail.data;
    }

    @Override
    public void push(Object element) {
        if (this.head == null) {
            DNode dNode = new DNode(element, null, null);
            this.head = dNode;
            this.tail = dNode;
            return;
        }

        DNode node = new DNode(element, null, this.tail);
        this.tail.next = node;
        this.tail = node;

    }

    @Override
    public boolean isEmpty() {
        return this.head == null ? true : false;
    }

    @Override
    public int size() {
        int size = 0;
        DNode temp = this.head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
    public void print(){
        DNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();

    }
}
