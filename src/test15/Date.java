/*
package test15;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        if (year < 0) throw new IllegalArgumentException("연도는 양수여야 함");
        if (month < 1 || month > 12) throw new IllegalArgumentException("월은 1~12까지의 숫자여야 함");
        if (day < 1 || day > getDaysInMonth(year, month)) throw new IllegalArgumentException("유효한 일이 아님");

        this.year = year;
        this.month = month;
        this.day = day;
    }


    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private static int getDaysInMonth(int year, int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 0;
        };
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
*/
