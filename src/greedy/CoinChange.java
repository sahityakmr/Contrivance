package greedy;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;

        System.out.println(possibleWays(sum, coins, 0));
        System.out.println(count(sum, coins.length - 1, coins));
    }

    private static int count(int sum, int index, int[] coins) {
        if(sum == 0)
            return 1;
        if(sum < 0 || index < 0)
            return 0;
        return count(sum, index - 1, coins) + count(sum - coins[index], index, coins);
    }

    private static int possibleWays(int sum, int[] coins, int index) {
        if(sum == 0)
            return 1;
        if(sum < 0)
            return 0;
        int ways = 0;
        for (int i = index; i < coins.length; i++) {
            ways += possibleWays(sum - coins[i], coins, i);
        }
        return ways;
    }
}

/*
    this method will count {5, 2, 3}, {5, 3, 2}, {2, 3, 5} .... as different
    private static int possibleWays(int sum, int[] coins) {
        if(sum == 0)
            return 1;
        if(sum < 0)
            return 0;
        int ways = 0;
        for (int coin : coins) {
            ways += possibleWays(sum - coin, coins);
        }
        return ways;
    }
 */