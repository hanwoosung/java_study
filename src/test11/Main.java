package test11;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Quiz> quizList = new ArrayList<>();

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("퀴즈 푸는 사람의 이름을 입력하세요");
            String name = sc.next();
            humanInsert(name);
            System.out.println("퀴즈를 내겠습니다.");
            select(sc,name);
            break;
        }
    }


    public static void humanInsert(String sc) throws SQLException {
        int result = HumanDAO.regist(sc);
        System.out.println(result != 0 ? "학생 등록 성공" : " 실패 ");
    }

    public static void select(Scanner sc, String name) throws SQLException {
        quizList = QuizDAO.select();
        for (Quiz quiz : quizList) {
            System.out.println(quiz.getNum() + "번째 문제 " + quiz.getContent());
            String ans = sc.next();
            if (ans.equals(quiz.getAnswer())) {
                System.out.println("정답입니다. 20점 추가");
               int result = HumanDAO.update(20,name);
                System.out.println(result != 0 ? "점수 업데이트 성공" : " 실패");
            }else{
                System.out.println("땡");
            }
        }
    }

}
