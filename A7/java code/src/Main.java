import Graph.AdjacencyList;
import Graph.AdjacencyMatrix;

public class Main {

    public static void main(String[] args) {
        int numberVertices = 9;

        PrimsMSTAdjacencyMatrix primsMSTAdjacencyMatrix = new PrimsMSTAdjacencyMatrix();
        PrimsMSTAdjacencyList primsMSTAdjacencyList = new PrimsMSTAdjacencyList();
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(numberVertices);
        AdjacencyList adjList = new AdjacencyList(numberVertices);

        // run time analysis
        long startTime;
        long endTime;

        // Create the adjacency matrix
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
//        adjMatrix.printGraph();

        System.out.println("----- Prim's MST with Adjacency Matrix -----\n");
        startTime = System.nanoTime();

        primsMSTAdjacencyMatrix.primsMST(adjMatrix, 0);

        endTime = System.nanoTime();
        System.out.println("Execution time: " + String.format("%.6f", (float)(endTime - startTime) / 1000000) + " ms.\n");

//        System.out.println("ADJACENCY MATRIX SOLUTION");
//        AdjacencyMatrix solution1 = new AdjacencyMatrix(numberVertices);
//        solution1.addEdge(0, 1, 4);
//        solution1.addEdge(0, 7, 8);
//        solution1.addEdge(2, 3, 7);
//        solution1.addEdge(2, 5, 4);
//        solution1.addEdge(2, 8, 2);
//        solution1.addEdge(3, 4, 9);
//        solution1.addEdge(5, 6, 2);
//        solution1.addEdge(6, 7, 1);
//        solution1.printGraph();

        // Create the adjacency list
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
//        adjList.printGraph();

        System.out.println("----- Prim's MST with Adjacency List -----\n");
        startTime = System.nanoTime();

        primsMSTAdjacencyList.primsMST(adjList, 0);

        endTime = System.nanoTime();
        System.out.println("Execution time: " + String.format("%.6f", (float)(endTime - startTime) / 1000000) + " ms.\n");

//        System.out.println("ADJACENCY LIST SOLUTION");
//        AdjacencyList solution = new AdjacencyList(numberVertices);
//        solution.addEdge(0, 1, 4);
//        solution.addEdge(0, 7, 8);
//        solution.addEdge(2, 3, 7);
//        solution.addEdge(2, 5, 4);
//        solution.addEdge(2, 8, 2);
//        solution.addEdge(3, 4, 9);
//        solution.addEdge(5, 6, 2);
//        solution.addEdge(6, 7, 1);
//        solution.printGraph();
    }
}
