import Graph.AdjacencyList;
import Graph.AdjacencyMatrix;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PrimsMSTAdjacencyMatrix primsMSTAdjacencyMatrix = new PrimsMSTAdjacencyMatrix();
        PrimsMSTAdjacencyList primsMSTAdjacencyList = new PrimsMSTAdjacencyList();

        long startTime;
        long endTime;
        long totalTime = 0;
        int vertices;
        int edges;
        int iterator = 1000; // number of iterations for prims

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        vertices = input.nextInt();
        System.out.print("Enter the number of edges: ");
        edges = input.nextInt();
        System.out.println();

        System.out.println("----- Prim's MST with Adjacency List -----");
        System.out.println("n = " + vertices + ", m = " + edges);
        AdjacencyList adjList = new AdjacencyList(vertices);

        for (int i = 0; i < iterator; i++) {
            adjList = adjList.makeAdjacencyList(vertices, edges);

            startTime = System.nanoTime();
            primsMSTAdjacencyList.primsMST(adjList, 0);
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        System.out.println(
                "Average Execution time: " +
                        String.format("%.6f", + (float) ((totalTime) / iterator) / 1000000) +
                        " ms."
        );

        System.out.println();

        System.out.println("----- Prim's MST with Adjacency Matrix -----");
        System.out.println("n = " + vertices + ", m = " + edges);
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(vertices);

        for (int i = 0; i < iterator; i++) {
            adjMatrix = adjMatrix.makeAdjacencyMatrix(vertices, edges);

            startTime = System.nanoTime();
            primsMSTAdjacencyMatrix.primsMST(adjMatrix, 0);
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        System.out.println(
                "Average Execution time: " +
                        String.format("%.6f", + (float) ((totalTime) / iterator) / 1000000) +
                        " ms."
        );
     }

    /**
     * Method used as a test case for both Prim's algorithms
     * on the following graph
     *
     *     (B)-8--(C)-7-(D)
     *   4/ |   2/  \    | \9
     * (A)  11 (I)   4  14  (E)
     *   8\ | /7      \  | /10
     *     (H)-1-(G)-2-(F)
     *
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
        System.out.println(
                "Execution time: " +
                        String.format("%.6f", (float) (endTime - startTime) / 1000000) +
                        " ms."
        );

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
        System.out.println(
                "Execution time: " +
                        String.format("%.6f", (float) (endTime - startTime) / 1000000) +
                        " ms."
        );

        primsMSTList.printGraph();
    }
}
