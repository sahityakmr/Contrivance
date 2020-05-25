package greedy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ActivitySelectionProblem {
    public static void main(String[] args) {
        int n = 6;
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};

        getMaxActivities(start, finish);
    }

    private static int getMaxActivities(int[] start, int[] finish) {
        List<Activity> sortedActivities = IntStream.range(0, finish.length)
                .mapToObj(i -> new Activity(start[i], finish[i], (i + 1)))
                .sorted(Comparator.comparingInt(activity -> activity.finish))
                .collect(Collectors.toList());

        int lastFinish = 0;
        int count = 0;
        for (Activity activity : sortedActivities) {
            if (activity.start >= lastFinish) {
                System.out.print(activity.index + " ");
                count++;
                lastFinish = activity.finish;
            }
        }
        System.out.println();
        return count;
    }

    static class Activity {
        int start;
        int finish;
        int index;

        public Activity(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }
    }
}
