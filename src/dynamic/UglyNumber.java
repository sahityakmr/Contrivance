package dynamic;

public class UglyNumber {
    // print first 150 ugly numbers
    // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 27, 30
    public static void main(String[] args) {
        System.out.println(nthUgly(150));
    }

    private static long nthUgly(int n) {
        long nextMultipleOfTwo = 2;
        long nextMultipleOfThree = 3;
        long nextMultipleOfFive = 5;
        int i2 = 1, i3 = 1, i5 = 1;

        long[] ugly = new long[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            long min = Math.min(nextMultipleOfTwo, Math.min(nextMultipleOfThree, nextMultipleOfFive));
            ugly[i] = min;
            if(min == nextMultipleOfTwo)
                nextMultipleOfTwo = 2 * ugly[i2++];
            if(min == nextMultipleOfThree)
                nextMultipleOfThree = 3 * ugly[i3++];
            if(min == nextMultipleOfFive)
                nextMultipleOfFive = 5 * ugly[i5++];
        }
        return ugly[n-1];
    }
}
