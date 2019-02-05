package Graphs;

import java.util.Iterator;

public class MatrixDiGraph<T>implements GraphADT<T> {
    double[][] matrix;
    int numOfVertices;
    int numOfEdges;
    private int SIZE = 50;
    T vertices[];

    @Override
    public void addVertex(T vertex) {
        vertices[numOfVertices] = vertex;
        numOfVertices++;
    }

    @Override
    public void removeVertex(T vertex) {
        boolean found = false;
        for (int i = 0; i<numOfVertices;i++){
            if(vertex==vertices[i]&&!found){
                found=true;
            }
            if(found){
                vertices[i]=vertices[i+1];
            }
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        matrix[getIndex(vertex1)][getIndex(vertex2)]=1;
        numOfEdges++;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        matrix[getIndex(vertex1)][getIndex(vertex2)]=0;
        numOfEdges--;

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
        return numOfVertices==0;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public int size() {
        return numOfVertices;
    }
    protected int getIndex(T vertex1) {
        int i = 0;
        boolean hasFound = false;
        while (i < vertices.length && hasFound == false) {
            if (vertex1.equals(vertices[i])) {
                hasFound = true;
            } else {
                i++;
            }
        }
        return i;
    }
}
