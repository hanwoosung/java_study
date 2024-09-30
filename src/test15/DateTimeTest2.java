package test15;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest2 {
    public static void main(String[] args) {

        //현재시각 구하기
        Date date1 = new Date();

        Calendar c = Calendar.getInstance();
        System.out.println(c);

        Date date2 = c.getTime();

        System.out.println(date1);
        System.out.println(date2);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(date1));
        System.out.println(sf.format(date2));

        Calendar c2 = Calendar.getInstance();
        c2.set(2024,Calendar.AUGUST,26,00,11,22);
        System.out.println(sf.format(c2.getTime()));




    }
}
