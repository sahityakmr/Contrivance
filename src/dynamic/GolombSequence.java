package dynamic;

import java.util.Arrays;

public class GolombSequence {
    public static void main(String[] args) {
        int n = 120;
        printNGolombNaive(n);
        printNGolomb(n);
    }

    private static void printNGolomb(int n) {
        int[] seq = new int[n];
        seq[0] = 1;
        for (int i = 1; i < n; i++) {
            seq[i] = 1 + seq[i - seq[seq[i - 1] - 1]];
        }
        System.out.println(Arrays.toString(seq));
    }

    private static void printNGolombNaive(int n) {
        int[] seq = new int[n];
        seq[0] = 1;
        seq[1] = 2;
        seq[2] = 2;
        int k = 3;
        int ptr = 3;
        while (ptr < n) {
            for (int i = 0; i < seq[k - 1] && ptr < n; i++) {
                seq[ptr] = k;
                ptr++;
            }
            k++;
        }
        System.out.println(Arrays.toString(seq));
    }
}
