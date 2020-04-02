package Graph;

/**
 * Creates and modifies an adjacency matrix for a undirected graph.
 */
public class AdjacencyMatrix {
    private int numberVertices;
    private int[][] adjMatrix;

    public AdjacencyMatrix(int numberVertices) {
        this.numberVertices = numberVertices;
        adjMatrix = new int[numberVertices][numberVertices];
    }

    public void addEdge(int i, int j, int weight) {
        if (adjMatrix[i][j] == 0 && adjMatrix[j][i] == 0) {
            adjMatrix[i][j] = weight;
            adjMatrix[j][i] = weight;
        } else {
            System.out.print("Edge between " + i + " and " + j + " exists. \n");
        }
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public boolean isEdge(int i, int j) {
        return adjMatrix[i][j] > 0;
    }

    public void printGraph() {
        System.out.println("=================");
        System.out.println("Adjacency Matrix:");
        System.out.println("=================");
        for (int i = 0; i < numberVertices; i++) {
            for (int j = 0; j < numberVertices; j++) {
                System.out.print(adjMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
