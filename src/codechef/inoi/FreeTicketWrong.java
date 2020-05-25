package codechef.inoi;

import java.util.Arrays;
import java.util.Scanner;

public class FreeTicketWrong {

    // to be debugged why floyed-warshell doesn't work this way.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityCount = sc.nextInt();
        int flightCount = sc.nextInt();
        int[][] fareGrid = new int[cityCount][cityCount];
        for (int i = 0; i < cityCount; i++) {
            for (int j = 0; j < cityCount; j++)
                fareGrid[i][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= flightCount; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int fare = sc.nextInt();
            fareGrid[src][dest] = fare;
            fareGrid[dest][src] = fare;
        }

        printAllPairShortestPath(fareGrid, cityCount);

        printFareGrid(fareGrid);
        //printCost(cityCount, fareGrid);
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
    }

    private static void printFareGrid(int[][] fareGrid) {
        for (int[] data : fareGrid)
            System.out.println(Arrays.toString(data));
    }

    private static void printCost(int cityCount, int[][] fareGrid) {
        int cost = 0;
        for (int i = 0; i < cityCount; i++) {
            for (int j = i + 1; j < cityCount; j++) {
                if (fareGrid[i][j] != Integer.MAX_VALUE && cost < fareGrid[i][j])
                    cost = fareGrid[i][j];
            }
        }
        System.out.println(cost);
    }
}
