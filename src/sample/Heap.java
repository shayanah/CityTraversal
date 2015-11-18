package sample;

import java.util.ArrayList;

/**
 * Created by shawn on 11/18/2015.
 */
public class Heap< T extends Comparable<T> > implements PriQueueInterface<T>
{

    private ArrayList<T> elements;
    private int lastIndex;
    private int maxIndex;
    public Heap(int maxSize)
    {
        elements = new ArrayList<T>(maxSize);
        lastIndex = -1;
        maxIndex = maxSize - 1 ;
    }
    @Override
    public boolean isEmpty() {
        return (lastIndex == -1);
    }

    @Override
    public boolean isFull() {
        return (lastIndex == maxIndex);
    }

    @Override
    public void enqueue() throws PriOverflowException {
        
    }

    @Override
    public void enqueue(T element) throws PriOverflowException
    {
        if(lastIndex == maxIndex)
            throw new PriOverflowException();
        else
        {
            lastIndex++;
            elements.add(lastIndex,element);
            reheapUp(element);
        }
    }

    private void reheapUp(T element)
    {

    }

    @Override
    public T dequeue() {
        return null;
    }
}
