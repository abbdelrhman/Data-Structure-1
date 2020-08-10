package eg.edu.alexu.csd.datastructure.queue.cs36;

public class ArrayBasedQueue implements IQueue,IArrayBased {
    private int arrLength ;
    private Object[] arr;
    private int front =-1;
    private int rare = -1 ;
    private int size =0;


    public ArrayBasedQueue(int arrLength) {
        this.arrLength = arrLength;
         arr = new Object[arrLength];
    }




    @Override
    public void enqueue(Object item) {
        if(isEmpty()){
            front = rare =0;
            arr[front]= item;
            size++;
            return;
        }
        if(((rare+1)%arrLength) == front || size == arrLength){
            throw new RuntimeException("the array is full");
        }
        size++;
        rare=(rare+1)%arrLength;
        arr[rare]=item;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new RuntimeException("the array is empty");
        }
        Object returnValue = arr[front];
        front =(front+1)%arrLength;
        size--;
        return returnValue;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
}
