package graph;

import java.util.*;
import java.lang.*;
import java.io.*;

class BellmanFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] fareGrid;
        while (t-- > 0) {
            int cityCount = sc.nextInt();
            fareGrid = new int[cityCount][cityCount];
            for (int i = 0; i < cityCount; i++)
                for (int j = 0; j < cityCount; j++)
                    fareGrid[i][j] = sc.nextInt();


            printAllPairShortestPath(fareGrid, cityCount);

        }
    }

    private static void printAllPairShortestPath(int[][] fareGrid, int cityCount) {
        for (int src = 0; src < cityCount; src++) {
            for (int intermediate = 0; intermediate < cityCount; intermediate++) {
                if (intermediate == src || fareGrid[src][intermediate] == Integer.MAX_VALUE)
                    continue;
                for (int dest = 0; dest < cityCount; dest++) {
                    if (src == dest || fareGrid[intermediate][dest] == Integer.MAX_VALUE)
                        continue;
                    if (fareGrid[src][dest] > fareGrid[intermediate][dest] + fareGrid[src][intermediate]) {
                        fareGrid[src][dest] = fareGrid[src][intermediate] + fareGrid[intermediate][dest];
                        fareGrid[dest][src] = fareGrid[src][dest];
                    }
                }
            }
        }

        printFareGrid(fareGrid);
    }

    private static void printFareGrid(int[][] fareGrid) {
        for (int[] data : fareGrid) {
            for (int item : data)
                System.out.print(item + " ");
            System.out.println();
        }
    }
}