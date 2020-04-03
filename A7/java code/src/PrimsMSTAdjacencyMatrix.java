import Graph.AdjacencyMatrix;
import java.util.ArrayList;

/**
 * Prim's Minimum Spanning Tree (MST) algorithm for graphs represented by an adjacency matrix.
 */
public class PrimsMSTAdjacencyMatrix {

    static final Integer inf = Integer.MAX_VALUE;

    static class vertex {
        int index;
        int key;
        vertex parent;
    }

    /**
     * Prim's algorithm to find a MST given an adjacency matrix
     *
     * @param graph the adjacency matrix to find MST for
     * @param root starting point for the MST
     * @return an adjacency matrix representation of the MST
     */
    AdjacencyMatrix primsMST(AdjacencyMatrix graph, int root) {
        if (graph == null) {
            throw new NullPointerException("Adjacency matrix is null.");
        }

        int[][] adjMatrix = graph.getAdjMatrix();
        // Subset of safe edges that make up the MST
        AdjacencyMatrix mstSet = new AdjacencyMatrix(graph.getNumberVertices());
        // Holds edges with the min. weight value
        vertex[] GV = new vertex[graph.getNumberVertices()];
        // Holds vertices not in MST based on key value
        ArrayList<vertex> queue = new ArrayList<>();

        for (int i = 0; i < graph.getNumberVertices(); i++) {
            GV[i] = new vertex();
            GV[i].key = inf;
            GV[i].index = i;
            GV[i].parent = null;
        }

        GV[root].key = 0;

        for (int i = 0; i < graph.getNumberVertices(); i++) {
            queue.add(GV[i]);
        }

        vertex u;
        while (!queue.isEmpty()) {
            u = listMin(queue);
            queue.remove(u);

            for (vertex v : GV) {
                // Updates key values for vertices adjacent to vertex u
                if (adjMatrix[u.index][v.index] > 0) {
                    if (queue.contains(v) && adjMatrix[u.index][v.index] <= v.key) {
                        v.parent = u;
                        v.key = adjMatrix[u.index][v.index];
                    }
                }
            }
        }

        int totalWeight = 0;
        // Add safe edges to A
        for (int i = 1; i < GV.length; i++) {
            mstSet.addEdge(i, GV[i].parent.index, adjMatrix[i][GV[i].parent.index]);
            totalWeight += adjMatrix[i][GV[i].parent.index];
        }

        System.out.println("Weight of MST is " + totalWeight);
        return mstSet;
    }

    /**
     * Finds the vertex with the min. key value
     *
     * @param queue the list of vertices
     * @return min the vertex with the min. key value
     */
    private vertex listMin(ArrayList<vertex> queue) {
        vertex min = queue.get(0);
        for (PrimsMinimumSpanningTree.vertex vertex : queue) {
            if (vertex.key <= min.key) {
                min = vertex;
            }
        }
        return min;
    }
}
