/*
package test15;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("연도 입력: ");
            int year = scanner.nextInt();
            System.out.print("월 입력: ");
            int month = scanner.nextInt();
            System.out.print("일 입력: ");
            int day = scanner.nextInt();

            Date date = new Date(year, month, day);
            System.out.println(date.getYear() + "년 " + date.getMonth() + "월 " + date.getDay() + "일");
            System.out.println((Date.isLeapYear(date.getYear()) ? "윤년임" : "윤년이 아님"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
