package Graph;

import java.util.LinkedList;
import java.util.Random;

/**
 * Creates and modifies an adjacency list for a undirected edge-weighted graph.
 */
public class AdjacencyList {
    private int numberVertices;
    private LinkedList<Edge>[] adjList;

    public class Edge {
        int src;
        public int dest;
        public int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public AdjacencyList(int numberVertices) {
        this.numberVertices = numberVertices;
        adjList = new LinkedList[numberVertices];

        for (int i = 0; i < numberVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adjList[src].addFirst(edge);

        edge = new Edge(dest, src, weight);
        adjList[dest].addFirst(edge);
    }

    public void removeEdge(int src, int dest) {
        LinkedList<Edge> list = adjList[src];
        for (Edge e : list) {
            if (e.dest == dest) {
                list.remove(e);
                break;
            }
        }

        list = adjList[dest];
        for (Edge e : list) {
            if (e.dest == src) {
                list.remove(e);
                break;
            }
        }
    }

    public boolean isEdge(int i, int j) {
        if (j > adjList.length - 1) {
            throw new IndexOutOfBoundsException("Vertex j = " + j + " does not exist.");
        }

        LinkedList<Edge> list = adjList[i];
        for (Edge e : list) {
            if (e.dest == j) {
                return true;
            }
        }
        return false;
    }

    public void printGraph() {
        System.out.println("===============");
        System.out.println("Adjacency List:");
        System.out.println("===============");
        for (int i = 0; i < numberVertices; i++) {
            LinkedList<Edge> list = adjList[i];

            if (list.size() > 0) {
                System.out.print("Vertex " + i + " links to: ");

                for (Edge e : list) {
                    System.out.print(e.dest + " (weight: " + e.weight + ")\t");
                }

                System.out.println();
            } else {
                System.out.println("Vertex " + i + " is empty.");
            }
        }
        System.out.println();
    }

    /**
     * Creates an adjacency list representation of a connected edge-weighted graph
     * with randomly added edges and weights
     *
     * @param vertices number of vertices
     * @param edges number of edges
     * @return adjacency list with n vertices and m edges
     */
    public AdjacencyList makeAdjacencyList(int vertices, int edges) {
        AdjacencyList adjList = new AdjacencyList(vertices);
        Random random = new Random();

        int weightMax = vertices/2;
        int min = 0;
        int weight;
        int randomSrc;
        int randomDest;

        // create connected graph
        for (int i = 0; i < vertices; i++) {
            weight = min + random.nextInt(weightMax);
            // Make an edge from last element to first element
            if (i == vertices - 1) {
                adjList.addEdge(vertices - 1, 0, weight);
            } else {
                adjList.addEdge(i, i + 1, weight);
            }
        }

        edges = edges - vertices;
        while (edges > 0) {
            weight = min + random.nextInt(weightMax);
            randomSrc = min + random.nextInt(vertices);
            randomDest = min + random.nextInt(vertices);

            // Create edges if one does not already exist
            if (!adjList.isEdge(randomSrc, randomDest) && randomSrc != randomDest) {
                adjList.addEdge(randomSrc, randomDest, weight);
                edges--;
            }
        }

        return adjList;
    }

    public int getNumberVertices() {
        return this.numberVertices;
    }

    public LinkedList<Edge>[] getAdjacencyList() {
        return adjList;
    }
}
