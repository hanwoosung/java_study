package test17.view;

import test17.dao.RpsDaoImpl;
import test17.dao.RpsVictoryDao;
import test17.dao.ScoreDao;
import test17.dao.ScoreDaoImpl;
import test17.dto.RpsVictoryDto;
import test17.dto.ScoreDto;
import test17.dto.respones.InfoDto;

import java.util.ArrayList;
import java.util.Scanner;

public class MainView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ScoreDao scoreDao = new ScoreDaoImpl();
    private static final RpsVictoryDao rpsDao = new RpsDaoImpl();
    private static String loggedInUser = null;

    public static void main(String[] args) {
        while (true) {
            if (loggedInUser == null) {
                System.out.print("로그인할 이름을 입력하시오: ");
                loggedInUser = scanner.next();
            }

            System.out.println("1. 가위 바위 보 게임");
            System.out.println("2. 점수 보기");
            System.out.println("3. 로그아웃");
            System.out.print("메뉴 선택하시오: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playGame();
                    break;
                case 2:
                    viewScores();
                    break;
                case 3:
                    loggedInUser = null;
                    System.out.println("로그아웃되었습니다.");
                    break;
                default:
                    System.out.println("다시 선택하시오");
            }
        }
    }

    private static void playGame() {
        System.out.print("가위(1), 바위(2), 보(3) 중 하나를 고르시오: ");
        int userMove = scanner.nextInt();
        int computerMove = (int) (Math.random() * 3) + 1;
        int score;
        String rps = " ";
        String isCheckWin;

        switch (userMove) {
            case 1:
                rps = "S";
                break;
            case 2:
                rps = "R";
                break;
            case 3:
                rps = "P";
                break;
        }

        System.out.println("컴퓨터의 선택은: " + (computerMove == 1 ? "가위" : computerMove == 2 ? "바위" : "보"));

        String result = (userMove == computerMove) ? "비겼습니다" :
                (userMove % 3 + 1 == computerMove) ? "졌습니다" : "이겼습니다";

        System.out.println(result);

        if (result.equals("비겼습니다")) {
            score = 0;
            isCheckWin = "D";
        } else if (result.equals("졌습니다")) {
            score = -10;
            isCheckWin = "L";
        } else {
            score = 10;
            isCheckWin = "W";
        }


        scoreDao.saveScore(new ScoreDto(0, loggedInUser, score));
        rpsDao.saveRps(new RpsVictoryDto(0, loggedInUser, rps, isCheckWin));
    }

    private static void viewScores() {
        System.out.println("1. 점수 전체 보기");
        System.out.println("2. 내 점수 보기");
        System.out.print("옵션 선택하시오: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                scoreDao.getAllScores().forEach(score ->
                        System.out.println("랭킹: " + score.getSno() + ", 이름: " + score.getSname() + ", 점수: " + score.getScore()));
                break;
            case 2: {
                scoreDao.getUserScores(loggedInUser).forEach(score ->
                        System.out.println(score.getSname() + ": " + score.getScore()));
                myInfo();
            }
            break;
            default:
                System.out.println("다시 입력");
        }
    }

    private static void myInfo() {
        rpsDao.getMyInfo(loggedInUser).forEach(it -> System.out.println(it.toString()));
    }
}
