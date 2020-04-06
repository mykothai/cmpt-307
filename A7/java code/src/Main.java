import Graph.AdjacencyList;
import Graph.AdjacencyMatrix;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        PrimsMSTAdjacencyMatrix primsMSTAdjacencyMatrix = new PrimsMSTAdjacencyMatrix();
        PrimsMSTAdjacencyList primsMSTAdjacencyList = new PrimsMSTAdjacencyList();
        AdjacencyMatrix adjMatrix;
        AdjacencyList adjList;

        long startTime;
        long endTime;

        int vertices = 400;
        int edges = 79800;

        int iterator = 100;
        long totalTime = 0;

        System.out.println("----- Prim's MST with Adjacency Matrix -----");
        System.out.println("n = " + vertices + ", m = " + edges);

        for (int i = 0; i < iterator; i++) {
            adjMatrix = makeAdjacencyMatrix(vertices, edges);

            startTime = System.nanoTime();
            primsMSTAdjacencyMatrix.primsMST(adjMatrix, 0);

            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        System.out.println("Average Execution time: " + String.format("%.6f", + (float)((totalTime) / iterator) / 1000000) + " ms.");
        System.out.println();

        System.out.println("----- Prim's MST with Adjacency List -----");
        System.out.println("n = " + vertices + ", m = " + edges);

        for (int i = 0; i < iterator; i++) {
            adjList = makeAdjacencyList(vertices, edges);
            startTime = System.nanoTime();

            primsMSTAdjacencyList.primsMST(adjList, 0);

            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        System.out.println("Average Execution time: " + String.format("%.6f", + (float)((totalTime) / iterator) / 1000000) + " ms.");
    }

    private static AdjacencyMatrix makeAdjacencyMatrix(int vertices, int edges) {
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(vertices);

        int weightMax = vertices/2;
        int min = 0;
        int weight;
        int randomSrc;
        int randomDest;
        Random random = new Random();

        // create connected graph
        for (int i = 0; i < vertices; i++) {
            weight = min + random.nextInt(weightMax);
            // make an edge from last element to first element
            if (i == vertices - 1) {
                adjMatrix.addEdge(vertices - 1, 0, weight);
            } else {
                adjMatrix.addEdge(i, i + 1, weight);
            }
        }

        edges = edges - vertices;
        while (edges > 0) {
            weight = min + random.nextInt(weightMax);
            randomSrc = min + random.nextInt(vertices);
            randomDest = min + random.nextInt(vertices);

            if (
                    adjMatrix.getAdjMatrix()[randomSrc][randomDest] == 0 &&
                    randomSrc != randomDest
            ) {
                adjMatrix.addEdge(randomSrc, randomDest, weight);
                edges--;
            }
        }

        return adjMatrix;
    }

    private static AdjacencyList makeAdjacencyList(int vertices, int edges) {
        AdjacencyList adjList = new AdjacencyList(vertices);

        int weightMax = vertices/2;
        int min = 0;
        int weight;
        int randomSrc;
        int randomDest;
        Random random = new Random();

        // create connected graph
        for (int i = 0; i < vertices; i++) {
            weight = min + random.nextInt(weightMax);
            // make an edge from last element to first element
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

            if (
                    !adjList.isEdge(randomSrc, randomDest) &&
                    randomSrc != randomDest
            ) {
                adjList.addEdge(randomSrc, randomDest, weight);
                edges--;
            }
        }

        return adjList;
    }

    /**
     * Method used as a test case for both Prim's algorithms
     */
    private static void primsExample() {
        PrimsMSTAdjacencyMatrix primsMSTAdjacencyMatrix = new PrimsMSTAdjacencyMatrix();
        PrimsMSTAdjacencyList primsMSTAdjacencyList = new PrimsMSTAdjacencyList();

        long startTime;
        long endTime;
        int numberVertices = 9;

        // Prim's for an adjacency matrix
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(numberVertices);
        adjMatrix.addEdge(0, 1, 4);
        adjMatrix.addEdge(0, 7, 8);
        adjMatrix.addEdge(1, 7, 11);
        adjMatrix.addEdge(1, 2, 8);
        adjMatrix.addEdge(2, 3, 7);
        adjMatrix.addEdge(2, 5, 4);
        adjMatrix.addEdge(2, 8, 2);
        adjMatrix.addEdge(3, 4, 9);
        adjMatrix.addEdge(3, 5, 14);
        adjMatrix.addEdge(4, 5, 10);
        adjMatrix.addEdge(5, 6, 2);
        adjMatrix.addEdge(6, 8, 6);
        adjMatrix.addEdge(6, 7, 1);
        adjMatrix.addEdge(7, 8, 7);
        System.out.println("----- Original Adjacency Matrix -----");
        adjMatrix.printGraph();

        System.out.println("----- Prim's MST with Adjacency Matrix -----");
        startTime = System.nanoTime();

        AdjacencyMatrix primsMSTMatrix = primsMSTAdjacencyMatrix.primsMST(adjMatrix, 0);

        endTime = System.nanoTime();
        System.out.println("Execution time: " + String.format("%.6f", (float)(endTime - startTime) / 1000000) + " ms.");

        primsMSTMatrix.printGraph();

        // Prim's for an adjacency list
        AdjacencyList adjList = new AdjacencyList(numberVertices);
        adjList.addEdge(0, 1, 4);
        adjList.addEdge(0, 7, 8);
        adjList.addEdge(1, 7, 11);
        adjList.addEdge(1, 2, 8);
        adjList.addEdge(2, 3, 7);
        adjList.addEdge(2, 5, 4);
        adjList.addEdge(2, 8, 2);
        adjList.addEdge(3, 4, 9);
        adjList.addEdge(3, 5, 14);
        adjList.addEdge(4, 5, 10);
        adjList.addEdge(5, 6, 2);
        adjList.addEdge(6, 8, 6);
        adjList.addEdge(6, 7, 1);
        adjList.addEdge(7, 8, 7);
        System.out.println("----- Original Adjacency List -----");
        adjList.printGraph();

        System.out.println("----- Prim's MST with Adjacency List -----");
        startTime = System.nanoTime();

        AdjacencyList primsMSTList = primsMSTAdjacencyList.primsMST(adjList, 0);

        endTime = System.nanoTime();
        System.out.println("Execution time: " + String.format("%.6f", (float)(endTime - startTime) / 1000000) + " ms.");

        primsMSTList.printGraph();
    }
}
