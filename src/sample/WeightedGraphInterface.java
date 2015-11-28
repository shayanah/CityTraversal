package sample;

/**
 * Created by shawn on 11/18/2015.
 */
public interface WeightedGraphInterface<V,E>
{
    boolean isEmpty();
    boolean isFull();
    void addVertex(V vertex);
    boolean hasVertex(V vertex);
    void addEdge(E edge);
    int weightIs(V vertex1,V vertex2);
}
