package greedy;

public class JobSequencing {
    static class Job{
        String id;
        int deadline;
        int profit;

        public Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        // sequence these jobs to maximize the profit
        Job[] jobs =new Job[]{
                new Job("a", 4, 20),
                new Job("b", 1, 10),
                new Job("c", 1, 40),
                new Job("d", 1, 30)
        };
    }
}
