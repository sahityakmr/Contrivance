package codechef.inoi;

import java.util.Arrays;
import java.util.Scanner;

class FreeTicket {
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
            int fromCity = sc.nextInt() - 1;
            int toCity = sc.nextInt() - 1;
            int fare = sc.nextInt();
            fareGrid[fromCity][toCity] = fare;
            fareGrid[toCity][fromCity] = fare;
        }

        calculateAllPairShortestPath(fareGrid, cityCount);

        int cost = 0;
        for (int i = 0; i < cityCount; i++) {
            for (int j = i + 1; j < cityCount; j++) {
                if (fareGrid[i][j] != Integer.MAX_VALUE && cost < fareGrid[i][j])
                    cost = fareGrid[i][j];
            }
        }
        printFareGrid(fareGrid);
        //printCost(cityCount, fareGrid);
    }

    private static void calculateAllPairShortestPath(int[][] fareGrid, int cityCount) {
        for (int intermediate = 0; intermediate < cityCount; intermediate++) {
            for (int src = 0; src < cityCount - 1; src++) {
                for (int dest = src; dest < cityCount; dest++) {
                    if (src == intermediate || intermediate == dest
                            || fareGrid[dest][intermediate] == Integer.MAX_VALUE
                            || fareGrid[src][intermediate] == Integer.MAX_VALUE)
                        continue;
                    if (fareGrid[src][dest] > fareGrid[src][intermediate] + fareGrid[intermediate][dest]) {
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


/*
6
7
1 2 10
2 4 4
1 3 2
3 4 3
2 6 5
4 6 5
5 3 20
* */