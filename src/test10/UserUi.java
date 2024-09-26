package test10;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserUi {

    public void select() throws SQLException {
        ResultSet rs = StudentDAO.select();
        while (rs.next()) {
            System.out.print(
                    rs.getInt("num") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getInt("grade") + "\t" +
                            rs.getInt("class") + "\t" +
                            rs.getInt("snum") + "\t" +
                            rs.getInt("korea_score") + "\t" +
                            rs.getInt("math_score") + "\t" +
                            rs.getInt("english_score")
            );
            System.out.println("\n");
        }
    }

    public void update(Scanner sc) throws SQLException {
        System.out.println("수정할 학생 번호를 입력하세요");
        int num = sc.nextInt();
        System.out.println("1.이름 2.학년 3.반 4.번호 5.국어성적 6.수학성적 7.영어성적");
        int check = sc.nextInt();

        System.out.println("수정할 값을 입력하세요 ");
        String value = sc.next();

        int result = StudentDAO.update(num, check, value);
        System.out.println(result != 0 ? "성공" : "실패");
    }

    public void delete(Scanner sc) throws SQLException {
        System.out.println("삭제할 학생 번호를 입력하세요");
        int num = sc.nextInt();

        int result = StudentDAO.delete(num);
        System.out.println(result != 0 ? "성공" : "실패");
    }

    public void regist(Scanner sc) throws SQLException {
        System.out.println("학생 정보를 입력하세요");
        System.out.println("이름");
        String name = sc.next();

        System.out.println("학년");
        int grade = sc.nextInt();

        System.out.println("반");
        int s_class = sc.nextInt();

        System.out.println("번호");
        int snum = sc.nextInt();

        System.out.println("국어성적");
        int kor_s = sc.nextInt();

        System.out.println("수학성적");
        int math_s = sc.nextInt();

        System.out.println("영어성적");
        int eng_s = sc.nextInt();

        Student std = new Student(name, grade, s_class, snum, kor_s, math_s, eng_s);
        int result = StudentDAO.regist(std);
        System.out.println(result != 0 ? "성공" : "실패");
    }
}