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
    public void enqueue(T element) throws PriOverflowException
    {
        if(isFull())
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
        int hole = lastIndex;
        while( hole > 0 && element.compareTo( elements.get( (hole - 1)/2 ) ) > 0)
        {
            elements.set(hole, elements.get( (hole - 1)/2 ));
            hole = (hole - 1)/2;
        }
        elements.set(hole,element);
    }

    @Override
    public T dequeue() throws PriQUnderflowException
    {
        if(isEmpty())
            throw new PriQUnderflowException();
        else
        {
            T hold = elements.get(0);
            T toMove = elements.get(lastIndex);
            lastIndex--;
            if(!isEmpty())
                reheapDown(toMove);
            return hold; // return the largest element
        }
    }
    private void reheapDown(T element)
    {
        int hole = 0;
        int newHole = max(hole,element);

        while( newHole != hole )
        {
            elements.set(hole, elements.get( newHole ));
            hole = newHole;
        }
        elements.set(hole,element);
    }

    private int max(int hole, T element) {
        int left = hole * 2 + 1;
        int right = hole * 2 + 2;
        if(left > lastIndex)
            return hole;
        else if(left == lastIndex)
        {
            if(element.compareTo(elements.get(left)) < 0)
                return left;
            else
                return hole;
        }
        else
        {
            if(elements.get(left).compareTo(elements.get(right)) < 0 )
            {
                if(elements.get(right).compareTo(element) > 0)
                    return right;
                else
                    return hole;
            }
            else
            {
                if(elements.get(left).compareTo(element) > 0)
                    return left;
                else
                    return hole;
            }
        }
    }
}
