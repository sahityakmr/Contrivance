package codechef.lockdown;

import java.util.Scanner;

public class NameValue {
    static int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int value = 0;
            String name = sc.nextLine();
            for (int i = name.length() - 1; i >= 0; i--) {
                if (name.charAt(i) != 'a' && name.charAt(i) != 'o' && name.charAt(i) != 'i' && name.charAt(i) != 'e' && name.charAt(i) != 'u') {
                    value += exp(2, name.length() - 1 - i);
                    value = value % MOD;
                }
            }
            System.out.println(value % MOD);
        }
    }

    private static int exp(int base, int exp) {
        int res = 1;
        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp = exp / 2;
        }
        return res % MOD;
    }
}