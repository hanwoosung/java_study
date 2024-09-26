package test10;

import java.sql.SQLException;
import java.util.Scanner;

public class DBRun {
    public static void main(String[] args) throws SQLException {
        UserUi ui = new UserUi();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 학생 추가 2 학생 수정 3 학생 삭제 4 학생 전체 조회");
            switch (sc.nextInt()) {
                case 1:
                    ui.regist(sc);
                    break;
                case 2:
                    ui.update(sc);
                    break;
                case 3:
                    ui.delete(sc);
                    break;
                case 4:
                    ui.select();
                    break;
            }
        }
    }
}
