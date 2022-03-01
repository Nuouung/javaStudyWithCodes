package dateAndTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * 코드 출처
 * https://d2.naver.com/helloworld/645609
 */
public class OldJdkDate {

    public static void main(String[] args) {
        OldJdkDate oldJdkDate = new OldJdkDate();
        oldJdkDate.shouldGetAfterOneDay();
    }

    public void shouldGetAfterOneDay() {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(utc);
        calendar.set(1582, Calendar.OCTOBER, 4);
        String pattern = "yyyy.MM.dd";
        String theDay = toString(calendar, pattern, utc);

        System.out.println("theDay = " + theDay);

        calendar.add(Calendar.DATE, 1);

        String nextDay = toString(calendar, pattern, utc);
        System.out.println("theDay에서 하루를 더한 nextDay = " + nextDay);
    }

    private String toString(Calendar calendar, String pattern, TimeZone zone) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setTimeZone(zone);
        return format.format(calendar.getTime());
    }

}
