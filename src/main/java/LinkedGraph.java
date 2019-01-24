import Interfaces.GraphADT;
import ListsAndIterators.ElementNotFoundException;
import ListsAndIterators.*;

import java.util.Iterator;

public abstract class LinkedGraph<T> implements GraphADT<T> {

    ArrayUnorderedList<GraphNode<T>> verteces;
    ArrayUnorderedList<Edge<T>> edges;

    @Override
    public void addVertex(T vertex) {
        verteces.addToRear(new GraphNode<T>(vertex, null));
    }


    @Override
    public void addEdge(T vertex1, T vertex2) {


    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {

    }

    @Override
    public Iterator iteratorBFS(T startVertex) {
        return null;
    }

    @Override
    public Iterator iteratorDFS(T startVertex) {
        return null;
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
