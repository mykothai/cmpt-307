package Graph;

import java.util.Random;

/**
 * Creates and modifies an adjacency matrix for a undirected edge-weighted graph.
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

    /**
     * Creates an adjacency matrix representation of a connected edge-weighted graph
     * with randomly added edges and weights
     *
     * @param vertices number of vertices
     * @param edges number of edges
     * @return adjacency matrix with n vertices and m edges
     */
    public AdjacencyMatrix makeAdjacencyMatrix(int vertices, int edges) {
        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(vertices);
        Random random = new Random();

        int weightMax = vertices/2;
        int min = 0;
        int weight;
        int randomSrc;
        int randomDest;

        // Create connected graph
        for (int i = 0; i < vertices; i++) {
            weight = min + random.nextInt(weightMax);
            // Make an edge from last element to first element
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

            // Create edges if one does not already exist
            if (adjMatrix.getAdjMatrix()[randomSrc][randomDest] == 0 && randomSrc != randomDest) {
                adjMatrix.addEdge(randomSrc, randomDest, weight);
                edges--;
            }
        }

        return adjMatrix;
    }

    public int getNumberVertices() {
        return numberVertices;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}
