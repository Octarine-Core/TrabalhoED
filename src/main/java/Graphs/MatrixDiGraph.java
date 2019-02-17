package Graphs;

import LinkedListsStacksAndQueues.LinkedQueue;
import ListsAndIterators.ArraySet;
import ListsAndIterators.ArrayUnorderedList;

import java.util.Iterator;

public class MatrixDiGraph<T>implements GraphADT<T> {
    double[][] matrix;
    int numOfVertices;
    int numOfEdges;
    protected int SIZE = 50;
    T vertices[];

    public MatrixDiGraph() {
        matrix = new double[SIZE][SIZE];
        vertices = (T[]) new Object[SIZE];
        numOfEdges = 0;
        numOfVertices = 0;
    }

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
        LinkedQueue<T> queue = new LinkedQueue<>();
        ArraySet<T> visitedVertices = new ArraySet<>();
        visitedVertices.add(startVertex);
        queue.enqueue(startVertex);

        while (!queue.isEmpty()){
            T v = queue.dequeue();
            for(int i = 0; i<numOfVertices; i++){
                for (int j = 0;j < matrix[getIndex(v)].length; j++) {
                    if(matrix[getIndex(v)][j]!= 0 && !visitedVertices.contains(vertices[j])){
                        queue.enqueue(vertices[j]);
                        visitedVertices.add(vertices[j]);
                    }
                }
            }
        }

        return visitedVertices.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) {
        return null;
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        ArrayUnorderedList<T> iterList = new ArrayUnorderedList<>();
        //Code goes here

        return iterList.iterator();
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
