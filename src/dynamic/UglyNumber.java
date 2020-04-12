package dynamic;

import java.util.Arrays;

public class UglyNumber {
    // print first 150 ugly numbers
    // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 27, 30
    public static void main(String[] args) {
        int nextMultipleOfTwo = 2;
        int nextMultipleOfThree = 3;
        int nextMultipleOfFive = 5;
        int i2 = 1, i3 = 1, i5 = 1;

        int[] ugly = new int[150];
        ugly[0] = 1;
        for (int i = 1; i < 150; i++) {
            int min = Math.min(nextMultipleOfTwo, Math.min(nextMultipleOfThree, nextMultipleOfFive));
            ugly[i] = min;
            if(min == nextMultipleOfTwo)
                nextMultipleOfTwo = 2 * ugly[i2++];
            if(min == nextMultipleOfThree)
                nextMultipleOfThree = 3 * ugly[i3++];
            if(min == nextMultipleOfFive)
                nextMultipleOfFive = 5 * ugly[i5++];
        }
        System.out.println(Arrays.toString(ugly));
    }
}
