package graph;

import java.util.Scanner;

public class PrintAdjacencyGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int v = scanner.nextInt();
            int e = scanner.nextInt();
            AdjacencyGraph graph = new AdjacencyGraph(v);
            for (int i = 0; i < e; i++) {
                int src = scanner.nextInt();
                int dest = scanner.nextInt();
                graph.add(src, dest);
            }
            graph.print();
        }
    }
}
/*
2
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
3 3
0 1
1 2
2 0
*/
