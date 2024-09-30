package test15;

import org.w3c.dom.css.Counter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTest3 {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(String.valueOf(now).substring(0,19).replace('T', ' '));

        LocalDate now2 = LocalDate.now();
        System.out.println(now2);

        LocalTime now3 = LocalTime.now();
        System.out.println(now3);

        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime birthday = LocalDateTime.of(1999,2,3,5,13,20);
        System.out.println(birthday);

        String str1 = birthday.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(str1);

        //형식 지정하기
        String str =  birthday.format(dtf);
        System.out.println(str);



    }
}
