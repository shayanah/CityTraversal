package sample;

/**
 * Created by shawn on 11/18/2015.
 */
public interface PriQueueInterface<T extends Comparable<T>>
{
    boolean isEmpty();
    boolean isFull();
    void enqueue() throws PriOverflowException;

    void enqueue(T element) throws PriOverflowException;

    T dequeue();
}