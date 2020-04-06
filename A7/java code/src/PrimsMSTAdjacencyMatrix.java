import Graph.AdjacencyMatrix;
import java.util.Comparator;
import java.util.PriorityQueue;

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

        PriorityQueue<Vertex> queue = new PriorityQueue<>(graph.getNumberVertices(), new Comparator<>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
                //sort using key values
                int key1 = v1.key;
                int key2 = v2.key;
                return key1 - key2;
            }
        });

        for (int i = 0; i < graph.getNumberVertices(); i++) {
            GV[i] = new Vertex(i, inf, null);
        }

        GV[root].key = 0;

        for (int i = 0; i < graph.getNumberVertices(); i++) {
            queue.add(GV[i]);
        }

        Vertex u;
        while (!queue.isEmpty()) {
            u = queue.poll();

            for (Vertex v : GV) {
                // Updates key values for vertices adjacent to Vertex u
                if (adjMatrix[u.index][v.index] > 0) {
                    if (queue.contains(v) && adjMatrix[u.index][v.index] <= v.key) {
                        queue.remove(v);
                        v.parent = u;
                        v.key = adjMatrix[u.index][v.index];
                        queue.add(v);
                    }
                }
            }
        }

        // Add safe edges to A
        for (int i = 1; i < GV.length; i++) {
            mstSet.addEdge(i, GV[i].parent.index, adjMatrix[i][GV[i].parent.index]);
        }

        return mstSet;
    }
}
