import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class AdjGraph {
    public static int[][] matrix;
    public static boolean[] boolMatrix;
    public boolean directed;
    public static ArrayList<Integer> visited;

    public AdjGraph(int v) {
        matrix = new int[v][v];
        directed = false;
    }

    public void addEdge(int u, int v) {
        matrix[u][v] = 1;
        if (!directed) matrix[v][u] = 1;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; ++j)
                temp.append(ints[j]).append(" ");
            temp.append("\n");
        }
        return temp.toString();
    }

    public int degree(int v) {
        int degree = 0;
        for (int i = 0; i < matrix[v].length; ++i)
            degree += matrix[v][i];
        return degree;
    }

    public int inDegree(int v) {
        int degree = 0;
        for (int[] aMatrix : matrix) degree += aMatrix[v];
        return degree;
    }

    public int outDegree(int v) {
        int degree = 0;
        for (int i = 0; i < matrix[v].length; ++i)
            degree += matrix[v][i];
        return degree;
    }

    public boolean isDirected() {
        return directed;
    }

    void DFS() {
        visited = new ArrayList<>();
        for (int i = 0; i < matrix.length; ++i)
            if (!visited.contains(i))
                depthFirstSearch(matrix[i], i, matrix);
    }

    private void depthFirstSearch(int[] v, int n, int[][] matrix) {
        System.out.println("Visiting vertex :" + n);
        visited.add(n);

        for (int i = 0; i < v.length; ++i)
            if (v[i] == 1 && !visited.contains(i))
                depthFirstSearch(matrix[i], i, matrix);
    }

    void BFS() {
        visited = new ArrayList<>();
        for (int i = 0; i < matrix.length; ++i)
            if (!visited.contains(i))
                breadthFirstSearch(matrix[i], i, matrix);
    }

    private void breadthFirstSearch(int[] v, int n, int[][] matrix) {
        System.out.println("Visiting vertex: " + n);
        visited.add(n);

        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(n);

        while (!queue.isEmpty()) {
            for (int i = 0; i < matrix[queue.peek()].length; ++i)
                if (matrix[queue.peek()][i] == 1 && !visited.contains(i)) {
                    System.out.println("Visiting vertex: " + i);
                    visited.add(i);
                    queue.add(i);
                }
            queue.poll();
        }
    }

    public boolean hasCycle() {
        boolMatrix = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            boolMatrix[i] = false;
        }

        for (int j = 0; j < matrix.length; j++) {
            if (!boolMatrix[j]) {
                if (directed) {
                    for (int k = 0; k < matrix.length; k++) {
                        boolMatrix[k] = false;
                    }
                }
                if (hasCycleUtils(j, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleUtils(int v, int parent) {
        boolMatrix[v] = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[v][i] == 1) {
                if (!boolMatrix[i]) {
                    if (hasCycleUtils(i, v)) {
                        return true;
                    } else if (i != parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
