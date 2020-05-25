package greedy;

public class WaterConnectionProblem {
    public static void main(String[] args) {
        int n = 9;
        int p = 6;
        int[][] connections = {{7, 4, 98}, {5, 9, 72}, {4, 6, 10}, {2, 8, 22}, {9, 7, 17}, {3, 1, 66}};
        int[][] solution = getSolution(n, connections);
    }

    private static int[][] getSolution(int n, int[][] connections) {
        // pre-requisite connected component in graph
        // https://www.geeksforgeeks.org/water-connection-problem/
        return new int[1][1];
    }
}
