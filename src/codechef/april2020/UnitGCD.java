package codechef.april2020;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnitGCD {
    public static final int BATCH_SIZE = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int threadCount = n % BATCH_SIZE;
            // if(n > BATCH_SIZE)


            int k = n / 2;
            if (n < 2)
                k = 1;
            System.out.println(k);
            if (n % 2 == 0)
                System.out.println("2 1 2");
            else if (n == 1)
                System.out.println("1 1");
            else
                System.out.println("3 1 2 3");
            int start = 4;
            int end = Math.max(n,BATCH_SIZE);
            ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
            for (int i = 0; i < threadCount; i++) {
                executorService.execute(new Task(start, end));
                start = end + 1;
                end += Math.max(n, BATCH_SIZE);
                if(end == n)
                    break;
            }
        }
    }

    static class Task implements Runnable {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i += 2) {
                System.out.println("2 " + i + " " + (i + 1));
            }
        }
    }
}
