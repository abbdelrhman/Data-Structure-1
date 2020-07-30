package eg.edu.alexu.csd.datastructure.linkedList.cs36;

import java.util.LinkedList;

public class SingleLinkedList implements ILinkedList {

    private Node head;
    private Node tail;


    @Override
    public void add(int index, Object element) {
        if (index > this.size() || index < 0) {
            throw new RuntimeException("null");
        }
        int i = 0;
        if (this.head == null) {
            if (index == 0) {
                Node addedNode = new Node(element, this.head);
                this.head = addedNode;
                this.tail = addedNode;
                return;
            } else {
                throw new RuntimeException("null");
            }
        }
        Node temp = this.head;
        while (temp != null) {
            if (index == 0) {
                Node addedNode = new Node(element, this.head);
                this.head = addedNode;
                return;
            } else if (temp.next == null && index == this.size()) {
                Node addedNode = new Node(element, null);
                temp.next = addedNode;
                this.tail = addedNode;
                return;
            } else {
                i++;
                Node prev = temp;
                temp = temp.next;
                if (i == index) {
                    Node addedNode = new Node(element, temp);
                    prev.next = addedNode;
                }
            }
        }
    }

    @Override
    public void add(Object element) {
        Node node = new Node(element, null);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= this.size() || index < 0 || this.head == null) {
            throw new IndexOutOfBoundsException();

        }
        int i = 0;
        Node temp = this.head;
        while (temp != null) {

            if (i == index) {
                return temp.data;
            }
            i++;
            temp = temp.next;

        }
        return null;
    }
    private Node get1(int index) {
        if (index >= this.size() || index < 0 || this.head == null) {
            throw new IndexOutOfBoundsException();

        }
        int i = 0;
        Node temp = this.head;
        while (temp != null) {

            if (i == index) {
                return temp;
            }
            i++;
            temp = temp.next;

        }
        return null;
    }

    @Override
    public void set(int index, Object element) {
        if (index >= this.size() || index < 0 || this.head == null) {
            throw new IndexOutOfBoundsException();

        }
        int i = 0;
        Node temp = this.head;
        while (temp != null) {

            if (i == index) {
                temp.data = element;
                return;
            }
            i++;
            temp = temp.next;

        }
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null ? true : false;
    }

    @Override
    public void remove(int index) {
        if (this.head == null || index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        //first element
        if (index == 0) {
            if (this.head == this.tail) {
                this.clear();
            } else {
                this.head = this.head.next;
            }
            return;
        }
        //last element
        if (index == this.size() - 1) {
            Node temp = this.head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            this.tail = temp;
            return;
        }
        int i = 0;
        Node temp = this.head;
        while (temp != null) {
            if (i == index - 1) {
                //do remove here
                temp.next = temp.next.next;
                return;
            }
            i++;
            temp = temp.next;
        }

    }

    @Override
    public int size() {
        int size = 0;
        Node temp = this.head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (fromIndex > toIndex
                || fromIndex > this.size()
                || toIndex > this.size() || fromIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        SingleLinkedList newLinkedList = new SingleLinkedList();
        Node start = this.get1(fromIndex);
        Node end =  this.get1(toIndex);
        int i = 0;
        while (start != end) {
            newLinkedList.add(i, start.data);
            start = start.next;
            i++;
        }
        newLinkedList.add(i, end.data);

        return newLinkedList;
    }

    @Override
    public boolean contains(Object o) {
        if (this.head == null) {
            throw new NullPointerException();
        }
        Node temp = this.head;
        while (temp != null){
            if( temp.data.equals(o)){ //when we need to use the equality of objects we use .equals
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void printList(SingleLinkedList list) {
        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }


}
