import Graph.AdjacencyMatrix;

public class Main {

    public static void main(String[] args) {
        int numberVertices = 9;

        PrimsMinimumSpanningTree primMST = new PrimsMinimumSpanningTree();
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(numberVertices);
        //AdjacencyList adjList = new AdjacencyList(numberVertices);

        // run time analysis
        long startTime = 0;
        long endTime = 0;

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

        adjMatrix.printGraph();

        System.out.println("----- Prim's MST with Adjacency Matrix -----\n");
        startTime = System.nanoTime();

        primMST.primsAdjacencyMatrix(adjMatrix);

        endTime = System.nanoTime();
        System.out.println("Execution time: " + String.format("%.6f", (float)(endTime - startTime) / 1000000) + " ms.\n");
    }
}
