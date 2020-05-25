package test;

import java.util.Random;
import java.util.stream.IntStream;

public class ChefAndBitwiseProductDataGen {
    public static void main(String[] args) {
        IntStream.range(0, 1000).forEach(ChefAndBitwiseProductDataGen::addCase);
    }

    private static void addCase(int seed) {
        int start = new Random(seed).nextInt(500);
        int end = start + new Random(seed * 2 + 1).nextInt(500);
        int left = new Random(seed).nextInt(300);
        int right = left + new Random(seed * 2 + 153).nextInt(500);
        System.out.println("[" + start + "," + end +"," + left + "," + right +"],");
    }
}
