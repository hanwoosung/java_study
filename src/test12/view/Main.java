package test12.view;

import test12.dao.ClubDao;
import test12.dao.StudentClubDao;
import test12.dao.StudentDao;
import test12.model.request.ClubDto;
import test12.model.request.StudentDto;
import test12.model.respones.StudentClubDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            switch (sc.nextInt()) {
                case 1:
                    studentAdd(sc);
                    break;
                case 2:
                    clubAdd(sc);
                    break;
                case 3:
                    clubJoin(sc);
                    break;
                case 4:
                    clubSelect();
                    break;
                case 5:
                    studentSelect();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    /**
     * 메뉴 출력
     */
    private static void printMenu() {
        System.out.println("1. 학생 등록");
        System.out.println("2. 동아리 등록");
        System.out.println("3. 동아리 가입");
        System.out.println("4. 동아리 목록 조회");
        System.out.println("5. 학생 목록 조회");
    }

    /**
     * 학생 등록
     */
    private static void studentAdd(Scanner sc) throws SQLException {
        System.out.print("학생 이름을 입력하세요: ");
        String name = sc.next();

        System.out.print("학생 지역을 입력하세요: ");
        String addr = sc.next();

        String resultMessage = (StudentDao.studentAdd(new StudentDto(name, addr)) != 0) ? "등록 성공" : "등록 실패";
        System.out.println(resultMessage);
    }

    /**
     * 동아리 등록
     */
    private static void clubAdd(Scanner sc) throws SQLException {
        sc.nextLine();
        System.out.print("동아리 이름을 입력하세요: ");
        String clubName = sc.nextLine();

        System.out.print("동아리 방번호를 입력하세요: ");
        String roomNumber = sc.nextLine();

        String resultMessage = (ClubDao.clubAdd(new ClubDto(clubName, roomNumber)) != 0) ? "등록 성공" : "등록 실패";
        System.out.println(resultMessage);
    }

    /**
     * 동아리 가입
     */
    private static void clubJoin(Scanner sc) throws SQLException {
        System.out.print("가입할 학생의 이름을 입력하세요: ");
        String name = sc.next();

        sc.nextLine();
        System.out.print("가입할 동아리 이름을 입력하세요: ");
        String clubName = sc.nextLine();

        String resultMessage = (StudentClubDao.clubJoin(name, clubName) != 0) ? "가입 성공" : "가입 실패";
        System.out.println(resultMessage);
    }

    /**
     * 동아리 조회
     */
    private static void clubSelect() throws SQLException {
        ArrayList<ClubDto> clubList = ClubDao.clubSelect();
        if (clubList.isEmpty()) {
            System.out.println("등록된 동아리가 없습니다.");
        } else {
            for (ClubDto club : clubList) {
                System.out.println(club);
            }
        }
    }

    /**
     * 학생 조회
     */
    private static void studentSelect() throws SQLException {
        ArrayList<StudentClubDto> stdClubList = StudentDao.studentSelect();
        if (stdClubList.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
        } else {
            for (StudentClubDto stdClub : stdClubList) {
                System.out.println(stdClub);
            }
        }
    }
}