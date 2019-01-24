import ListsAndIterators.UnorderedListADT;

import java.rmi.activation.UnknownObjectException;

public class GraphNode<T> {
    T data;
    UnorderedListADT<Edge<T>> edges;

    public GraphNode(T data, UnorderedListADT<Edge<T>> edges) {
        this.data = data;
        this.edges = edges;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public UnorderedListADT<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(UnorderedListADT<Edge<T>> edges) {
        this.edges = edges;
    }
}
