package dateAndTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * 코드 출처
 * https://d2.naver.com/helloworld/645609
 */
public class OldJdkDate2 {

    public static void main(String[] args) {
        OldJdkDate2 oldJdkDate2 = new OldJdkDate2();
        oldJdkDate2.shouldGetAfterOneHour();
    }

    public void shouldGetAfterOneHour() {
        TimeZone seoul = TimeZone.getTimeZone("Asia/Seoul");
        Calendar calendar = Calendar.getInstance(seoul);
        calendar.set(1988, Calendar.MAY, 7, 23, 0);
        String pattern = "yyyy.MM.dd HH:mm";
        String theTime = toString(calendar, pattern, seoul);
        System.out.println("theTime = " + theTime);

        calendar.add(Calendar.HOUR_OF_DAY, 1);
        String afterHour = toString(calendar, pattern, seoul);
        System.out.println("theTime에서 한 시간을 더한 afterHour = " + afterHour);
    }

    private String toString(Calendar calendar, String pattern, TimeZone zone) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setTimeZone(zone);
        return format.format(calendar.getTime());
    }

}
