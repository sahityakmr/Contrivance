import java.time.ZonedDateTime;
import java.time.temporal.TemporalField;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Date date = new Date();
        System.out.println(date.getTime());
    }
}
