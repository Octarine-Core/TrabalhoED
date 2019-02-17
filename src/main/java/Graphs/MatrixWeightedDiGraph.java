package Graphs;

import ListsAndIterators.ArrayOrderedList;
import ListsAndIterators.ArrayUnorderedList;
import ListsAndIterators.UnorderedListADT;
import UserData.User.Pair;

public class MatrixWeightedDiGraph<T> extends MatrixDiGraph<T> implements NetworkADT<T> {

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        matrix[getIndex(vertex1)][getIndex(vertex2)] = weight;
        numOfEdges++;
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        double[] distanceArray = Utils.dijkstra(matrix,getIndex(vertex1), SIZE);
        return distanceArray[getIndex(vertex2)];
    }




}
