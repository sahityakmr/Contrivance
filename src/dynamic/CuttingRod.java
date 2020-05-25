package dynamic;

public class CuttingRod {
    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(getMaxPrice(8, 0, prices));
    }

    private static int getMaxPrice(int n, int index, int[] prices) {
        int maxPrice = 0;
        for (int i = index; i < prices.length; i++) {
            maxPrice = Math.max(maxPrice, getMaxPrice(n - i - 1, i, prices));
        }
        return maxPrice;
    }
}
