// MECE 603
// ID No. 202484848
// Description: Assignment 5 solution

public class Main {
    public static void main(String[] args) {
        // (b) Test your code for the graph given below and show the final D and П matrices as outputs.
        int[][] graph = {
            {0, FloydWarshall.INF, FloydWarshall.INF, 3, FloydWarshall.INF},
            {3, 0, FloydWarshall.INF, FloydWarshall.INF, FloydWarshall.INF},
            {FloydWarshall.INF, FloydWarshall.INF, 0, 2, FloydWarshall.INF},
            {FloydWarshall.INF, 1, 1, 0, FloydWarshall.INF},
            {FloydWarshall.INF, FloydWarshall.INF, FloydWarshall.INF, 2, 0}
        };

        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(graph);
    }
}
