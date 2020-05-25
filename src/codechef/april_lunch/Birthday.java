package codechef.april_lunch;

import java.util.Arrays;
import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int cols = (int) Math.ceil(n * 1.0 / k);
            int[][] mat = new int[k][cols];
            int row = 0, col = 0;
            for (col = 0; col < cols; col++) {
                for (row = 0; row < k && col * k + row < n; row++) {
                    mat[row][col] = sc.nextInt();
                }
            }
            while (row < k) {
                mat[row][col - 1] = Integer.MAX_VALUE;
                row++;
            }
            if (k == 1) {
                System.out.println("yes");
                continue;
            }
            for (int i = 0; i < k; i++) {
                Arrays.sort(mat[i]);
            }
            boolean isSorted = true;
            int last = 0;
            for (col = 0; col < cols && isSorted; col++) {
                for (row = 0; row < k && col * k + row < n; row++) {
                    if(mat[row][col] < last){
                        isSorted = false;
                        break;
                    }
                    last = mat[row][col];
                }
            }
            if (isSorted)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
