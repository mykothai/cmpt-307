package Graph;

import java.util.LinkedList;

/**
 * Creates and modifies an adjacency list for a undirected graph.
 */
public class AdjacencyList {
    private int numberVertices;
    private LinkedList<Edge>[] adjList;

    public class Edge {
        public int src;
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

    public int getNumberVertices() {
        return this.numberVertices;
    }

    public LinkedList<Edge>[] getAdjacencyList() {
        return adjList;
    }
}
