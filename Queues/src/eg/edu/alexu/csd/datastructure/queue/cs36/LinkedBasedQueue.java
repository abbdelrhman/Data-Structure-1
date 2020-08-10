package eg.edu.alexu.csd.datastructure.queue.cs36;


import eg.edu.alexu.csd.datastructure.linkedList.cs36.SingleLinkedList;

public class LinkedBasedQueue implements IQueue, ILinkedBased {
    private SingleLinkedList Queue = new SingleLinkedList();

    @Override
    public void enqueue(Object item) {
       Queue.add(item);

    }

    @Override
    public Object dequeue() {
        Object returnValue = Queue.get(0);
        Queue.remove(0);
        return returnValue;
    }

    @Override
    public boolean isEmpty() {
        return Queue.isEmpty();
    }

    @Override
    public int size() {
        return Queue.size();
    }
}
