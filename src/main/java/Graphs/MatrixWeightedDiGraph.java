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
        ArrayUnorderedList<Pair<T, Double>> allVertices = new ArrayUnorderedList<>();
        ArrayUnorderedList<T> visitedVertices = new ArrayUnorderedList<T>();
        ArrayUnorderedList<T> notVisitedVertices = new ArrayUnorderedList<>();
        visitedVertices.addToRear(vertex1);
        for (T vertex :
                vertices) {
            if (vertex != vertex1){
                allVertices.addToRear(new Pair<T, Double>(vertex, 2.0));
            }
        }



        return 0;
    }
}
