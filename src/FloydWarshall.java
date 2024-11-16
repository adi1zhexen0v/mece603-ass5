public class FloydWarshall {
    public static final int INF = Integer.MAX_VALUE;

    // (a) Implement the Floyd-Warshall’s algorithm using the dynamic programming approach we saw in
    //     class. Your program should take as input the weight matrix W (through either the console or reading
    //     from a file) of dimensions not more than 6x6.
    public int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;

        if (n > 6 || m > 6) {
            System.out.println("Error: The graph matrix must not exceed 6x6 dimensions.");
            return null;
        }

        int[][] distance = new int[n][m];
        int[][] predecessor = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                    predecessor[i][j] = -1;
                } else if (graph[i][j] != INF) {
                    distance[i][j] = graph[i][j];
                    predecessor[i][j] = i;
                } else {
                    distance[i][j] = INF;
                    predecessor[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (distance[i][k] != INF && distance[k][j] != INF) {
                        int newDistance = distance[i][k] + distance[k][j];
                        if (distance[i][j] > newDistance) {
                            distance[i][j] = newDistance;
                            predecessor[i][j] = predecessor[k][j];
                        }
                    }
                }
            }
        }

        printMatrix(graph, "Initial Graph");
        printMatrix(distance, "Final Distance Matrix");
        printMatrix(predecessor, "Predecessor Matrix");

        return distance;
    }

    public void printMatrix(int[][] matrix, String title) {
        System.out.println(title + ":");
        for (int[] row : matrix) {
            for (int value : row) {
                if (value == INF) {
                    System.out.print("INF ");
                } else if (value == -1) {
                    System.out.print("NIL ");
                } else {
                    System.out.print(" " + value + "  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
