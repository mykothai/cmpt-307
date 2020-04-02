import Graph.AdjacencyList;
import Graph.AdjacencyMatrix;

public class PrimsMinimumSpanningTree {

    public PrimsMinimumSpanningTree() {}

    public void primsAdjacencyList(AdjacencyList graph) {
        if (graph == null) {
            throw new NullPointerException("Adjacency list is null.");
        }

    }

    public void primsAdjacencyMatrix(AdjacencyMatrix graph) {
        if (graph == null) {
            throw new NullPointerException("Adjacency matrix is null.");
        }

    }
}
