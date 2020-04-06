import Graph.AdjacencyList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Prim's Minimum Spanning Tree (MST) algorithm for graphs represented by an adjacency list.
 */
public class PrimsMSTAdjacencyList {

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

    AdjacencyList primsMST(AdjacencyList graph, int root) {
        if (graph == null) {
            throw new NullPointerException("Adjacency matrix is null.");
        }

        LinkedList<AdjacencyList.Edge>[] adjList = graph.getAdjacencyList();
        // Subset of safe edges that make up the MST
        AdjacencyList mstSet = new AdjacencyList(graph.getNumberVertices());
        // Holds edges with the min. weight value
        Vertex[] GV = new Vertex[graph.getNumberVertices()];

        PriorityQueue<Vertex> queue = new PriorityQueue<>(graph.getNumberVertices(), new Comparator<>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
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
        while(!queue.isEmpty()) {
            u = queue.poll();

            for (AdjacencyList.Edge e : adjList[u.index]) {
                if (queue.contains(GV[e.dest]) && e.weight < GV[e.dest].key) {
                    queue.remove(GV[e.dest]);
                    GV[e.dest].parent = u;
                    GV[e.dest].key = e.weight;
                    queue.add(GV[e.dest]);
                }
            }
        }

        // Add safe edges to A
        for (int i = 1; i < GV.length; i++) {
            if (GV[i] != null) {
                mstSet.addEdge(i, GV[i].parent.index, GV[i].key);
            }
        }

        return mstSet;
    }
}
