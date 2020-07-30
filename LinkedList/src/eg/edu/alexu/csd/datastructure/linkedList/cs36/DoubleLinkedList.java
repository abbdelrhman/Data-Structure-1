package eg.edu.alexu.csd.datastructure.linkedList.cs36;


import java.awt.*;

public class DoubleLinkedList implements ILinkedList {
    private DNode head;
    private DNode tail;

    public DNode getHead() {
        return head;
    }

    public DNode getTail() {
        return tail;
    }

    @Override
    public void add(int index, Object element) {
        if (index > this.size() || index < 0) {
            throw new RuntimeException("null");
        }

        if (index > 0 && this.head ==null){
            throw new RuntimeException("null");
        }
        //add at the beginning
        if(index == 0){
            DNode dNode = new DNode(element,null,null);
            if(this.head == null){
                this.head =dNode;
                this.tail =dNode;
            }else {
                dNode.next = this.head;
                this.head.prev = dNode ;
                this.head = dNode;
            }
            return;
        }
        //add at the end of the list
        if(index == this.size()){
            DNode dNode = new DNode(element,null,this.tail);
            this.tail.next = dNode;
            this.tail=dNode;
            return;
        }

        //add at the middle of the list
        int i=0 ;
        DNode temp = this.head ;
        while (temp!=null){
            if(i==index-1){
                DNode dNode = new DNode(element,temp.next,temp);
                temp.next.prev=dNode;
                temp.next=dNode;
                return;
            }
            i++;
            temp=temp.next;
        }

    }

    @Override
    public void add(Object element) {
        if(this.head == null){
            DNode dNode = new DNode(element,null,null);
            this.head =dNode;
            this.tail = dNode;
            return;
        }
        DNode node = new DNode(element,null,this.tail);
        this.tail.next = node ;
        this.tail = node;
    }

    @Override
    public Object get(int index) {
        if (index >= this.size() || index < 0 || this.head == null) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        DNode temp = this.head;
        while (temp != null) {

            if (i == index) {
//                System.out.print(temp.data + "->");
                return temp.data;
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
        DNode temp = this.head;
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
    this.head = null ;
    this.tail=null;
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
                this.head.next.prev = null;
                this.head = this.head.next;
            }
            return;
        }
        //last element
        if (index == this.size() - 1) {
            this.tail.prev.next = null;
            this.tail=this.tail.prev;
            return;
        }

        int i = 0;
        DNode temp = this.head;
        while (temp != null) {
            if (i == index ) {
                //do remove here
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
                return;
            }
            i++;
            temp = temp.next;
        }
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

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (fromIndex > toIndex
                || fromIndex > this.size()
                || toIndex > this.size() || fromIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        DoubleLinkedList newLinkedList = new DoubleLinkedList();
        DNode start = (DNode) this.get1(fromIndex);
        DNode end = (DNode) this.get1(toIndex);
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
        DNode temp = this.head;
        while (temp != null){
            if( temp.data.equals(o)){ //when we need to use the equality of objects we use .equals
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void printList(DoubleLinkedList list) {
        DNode temp = list.head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void reverseList (DoubleLinkedList list){
        DNode temp = list.tail;
        while (temp!=null){
            System.out.print(temp.data+"  ");
            temp=temp.prev;
        }
        System.out.println();
    }
    public DNode get1(int index) {
        if (index >= this.size() || index < 0 || this.head == null) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        DNode temp = this.head;
        while (temp != null) {

            if (i == index) {
//                System.out.print(temp.data + "->");
                return temp;
            }
            i++;
            temp = temp.next;

        }
        return null;
    }
}








