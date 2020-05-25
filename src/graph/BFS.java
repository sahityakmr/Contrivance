package graph;

import java.util.Scanner;
import java.util.stream.Collectors;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            AdjacencyGraph graph = new AdjacencyGraph(v);
            graph.setDirected(true);
            for (int i = 0; i < e; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                graph.add(src, dest);
            }
            graph.print();
            System.out.println(graph.traverseBFS(0).stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }
}
/*
1
20 19
0 8 0 13 1 14 2 18 3 12 4 14 5 9 6 9 7 14 8 9 8 12 8 16 9 11 9 15 10 12 12 14 12 17 12 19 13 18
*/