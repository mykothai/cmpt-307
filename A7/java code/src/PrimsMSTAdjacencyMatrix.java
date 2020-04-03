import Graph.AdjacencyMatrix;
import java.util.ArrayList;

/**
 * Prim's Minimum Spanning Tree (MST) algorithm for graphs represented by an adjacency matrix.
 */
public class PrimsMSTAdjacencyMatrix {

    static final Integer inf = Integer.MAX_VALUE;

    static class Vertex {
        int index;
        int key;
        Vertex parent;

        public Vertex(int index, int key, Vertex parent) {
            this.index = index;
            this.key = key;
            this.parent = parent;
        }
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
        Vertex[] GV = new Vertex[graph.getNumberVertices()];
        // Holds vertices not in MST based on key value
        ArrayList<Vertex> queue = new ArrayList<>();

        for (int i = 0; i < graph.getNumberVertices(); i++) {
            GV[i] = new Vertex(i, inf, null);
        }

        GV[root].key = 0;

        for (int i = 0; i < graph.getNumberVertices(); i++) {
            queue.add(GV[i]);
        }

        Vertex u;
        while (!queue.isEmpty()) {
            u = listMin(queue);
            queue.remove(u);

            for (Vertex v : GV) {
                // Updates key values for vertices adjacent to Vertex u
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
     * Finds the Vertex with the min. key value
     *
     * @param queue the list of vertices
     * @return min the Vertex with the min. key value
     */
    private Vertex listMin(ArrayList<Vertex> queue) {
        Vertex min = queue.get(0);
        for (Vertex vertex : queue) {
            if (vertex.key <= min.key) {
                min = vertex;
            }
        }
        return min;
    }
}
