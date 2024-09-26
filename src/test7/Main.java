package test7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager system = new Manager();

		while (true) {
			showMenu();
			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> registerStudent(sc, system);
			case 2 -> showGrades(sc, system);
			case 3 -> countBelow(sc, system);
			case 4 -> {
				System.out.println("시스템 종료.");
				return;
			}
			
			default -> System.out.println("잘못 입력함 다시 입력");

			}
		}
	}

	private static void showMenu() {
		System.out.println("1. 학생 등록");
		System.out.println("2. 성적 조회");
		System.out.println("3. 60점 미만 학생 수 조회");
		System.out.println("4. 종료");
		System.out.print("선택: ");
	}

	private static void registerStudent(Scanner sc, Manager system) {
	
		sc.nextLine();

		System.out.print("이름 입력하십숑: ");
		String name = sc.nextLine();
		System.out.print("성별 (남/여) 입력하십숑: ");
		String gender = sc.nextLine();
		System.out.print("학년 입력하십숑: ");
		int grade = sc.nextInt();
		System.out.print("국어 점수 입력하십숑: ");
		int koreanScore = sc.nextInt();
		System.out.print("영어 점수 입력하십숑: ");
		int englishScore = sc.nextInt();
		System.out.print("수학 점수 입력하십숑: ");
		int mathScore = sc.nextInt();
		System.out.print("선택 과목 점수 입력하십숑: ");
		int electiveScore = sc.nextInt();

		system.registerStudent(name, gender, grade, koreanScore, englishScore, mathScore, electiveScore);
	}

	private static void showGrades(Scanner sc, Manager system) {
	
		sc.nextLine();

		System.out.print("성별 (남/여): ");
		String searchGender = sc.nextLine();

		System.out.print("학년: ");
		int searchGrade = sc.nextInt();

		system.showGrades(searchGender, searchGrade);
	}

	private static void countBelow(Scanner sc, Manager system) {
		
		sc.nextLine();

		System.out.print("성별 (남/여): ");
		String countGender = sc.nextLine();

		System.out.print("학년: ");
		int countGrade = sc.nextInt();

		int count = system.countBelow(countGender, countGrade);
		System.out.println(count + "명");
	}
}