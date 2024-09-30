package test16;

import test16.dao.JoinDao;
import test16.view.BoardUi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        showMenu();
        while (true) {
            switch (sc.nextInt()) {
                case 1:
                    join(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void login(Scanner sc) {
        System.out.println("로그인할 아이디를 입력해주세요");
        String id = sc.next();
        boolean isLoginCheck = JoinDao.login(id);
        if (isLoginCheck) {
            System.out.println("로그인 성공 ");
            BoardUi boardUi = new BoardUi(id);
            boardUi.showBoardMenu();
        }
    }

    private static void showMenu() {
        System.out.println("메뉴 선택");
        System.out.println("1.회원가입 , 2.로그인 , 3.종료");
    }

    private static void join(Scanner sc) {
        System.out.println("아이디를 입력하세요");
        String id = sc.next();
        System.out.println("이름을 입력하세요");
        String name = sc.next();

        boolean isLoginCheck = JoinDao.join(id, name);

        if (isLoginCheck) {
            System.out.println("회원가입 성공");
            System.out.println("바로 로그인 하실거면 y 를 눌려주세요");
            String isCheck = sc.next();
            if (isCheck.equals("y")) {
                BoardUi boardUi = new BoardUi(id);
                boardUi.showBoardMenu();
            } else showMenu();
        } else showMenu();
    }
}
