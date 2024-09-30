package test14.view;

import test14.dao.WordDAO;
import test14.model.Word;

import java.util.Map;
import java.util.Scanner;

public class Dictionkey {
    private static WordDAO wordDAO = new WordDAO();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addWord();
                    break;
                case 2:
                    searchWord();
                    break;
                case 3:
                    allWords();
                    break;
                case 4:
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력. 다시 시도하십쇼.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("메뉴를 보고 입력하십쇼");
        System.out.println("1. 단어 등록");
        System.out.println("2. 단어 검색");
        System.out.println("3. 전체 단어 조회");
        System.out.println("4. 종료");
        System.out.print("선택하십쇼: ");
    }

    private static void addWord() {
        System.out.print("오늘 공부한 단어를 입력하십쇼: ");
        String eng = sc.nextLine();
        System.out.print("단어의 뜻을 입력하십쇼: ");
        String kor = sc.nextLine();

        wordDAO.addWord(eng, kor);
        System.out.printf("입력한 단어: %s, 단어의 뜻: %s\n", eng, kor);
    }

    private static void searchWord() {
        System.out.print("검색할 단어를 입력하십쇼: ");
        String eng = sc.nextLine();
        Word word = wordDAO.searchWord(eng);

        if (word != null) {
            System.out.println(word.getEnglish() + " 의 뜻은 " + word.getKorea() + " 입니다.");
        } else {
            System.out.println("해당 단어 없음");
        }
    }


    private static void allWords() {
        Map<String, Word> allWords = wordDAO.getAllWords();
        System.out.println("\n전체 단어장 목록 (" + allWords.size() + ")");
        for (Map.Entry<String, Word> entry : allWords.entrySet()) {
            Word word = entry.getValue();
            System.out.println(word.getEnglish() + " : " + word.getKorea());
        }
    }
}
