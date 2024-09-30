package test16.view;

import test16.dao.BoardDao;
import test16.dto.BoardDto;
import test16.dto.CommentDto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardUi {
    private static Scanner sc = new Scanner(System.in);
    private String id;

    public BoardUi(String id) {
        this.id = id;
    }

    private void selectAll() {
        ArrayList<BoardDto> boardList = BoardDao.getAllWords();
        System.out.println("게시글 목록(" + boardList.size() + ")");

        for (BoardDto board : boardList) {
            String create_at = String.format(board.getCreatedAt().toString()).substring(0, 11);
            String update_at = board.getUpdatedAt() != null ? String.format(board.getUpdatedAt().toString()).substring(0, 11) : " ";
            System.out.println(board.getBoardId() + ". 제목: " + board.getTitle() + "\t작성자: " + board.getUId() + "\t생성날짜: " + create_at + "\t수정날짜:" + update_at + "\t 댓글 개수 (" + board.getCommentCount() + ")");
        }
    }

    private void insertBoard() {
        System.out.println("게시판 제목을 입력하세요");
        String title = sc.nextLine();
        System.out.println("게시판 내용을 입력하세요");
        String content = sc.nextLine();
        System.out.println("공지사항 이라면 Y 아니라면 N을 입력하세요");
        String isNotice = sc.next();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        boolean isInsertCheck = BoardDao.insertBoard(new BoardDto(title, content, id, isNotice, timestamp));
        if (isInsertCheck) {
            showBoardMenu();
        }
    }

    private void insertComment(int board_no) {
        sc.nextLine();
        System.out.println("댓글 내용을 입력하세요");
        String content = sc.nextLine();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        boolean isInsertCheck = BoardDao.insertComment(new CommentDto(content, board_no, id, timestamp));

        if (isInsertCheck) {
            System.out.println("댓글 작성 성공");
            showBoardMenu();
        }
    }

    public void showBoardMenu() {
        selectAll();
        System.out.println("\n\n게시판 메뉴 선택");
        System.out.println("1.게시판 상세 , 2.게시글 등록");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                detailBoard();
                break;
            case 2:
                insertBoard();
                break;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }

    private void detailBoard() {
        System.out.println("보고 싶은 게시글 번호를 선택해주세요");

        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int board_no = sc.nextInt();
        sc.nextLine();

        BoardDto board = BoardDao.detailBoard(board_no);
        assert board != null;

        String date;
        if (board.getUpdatedAt() != null) {
            date = board.getUpdatedAt().toString().substring(0, 11);
        } else if (board.getCreatedAt() != null) {
            date = board.getCreatedAt().toString().substring(0, 11);
        } else {
            date = "날짜 없음";
        }

        String cate = board.getNoticeYn().equals("Y") ? "공지" : "일반";
        System.out.println("게시글 번호 " + board.getBoardId() + ". 제목: " + board.getTitle() + "\t작성자: " + board.getUId() + "\t카테고리: " + cate + "\t 날짜: " + date + "\n\n 내용: " + board.getContent());
        System.out.println("\n\n\n댓글 (" + board.getCommentList().size() + ")");

        for (int i = 0; i < board.getCommentList().size(); i++) {
            CommentDto comment = board.getCommentList().get(i);
            System.out.println((i + 1) + ": " + comment.getContent() + " (작성자: " + comment.getUId() + ")");
        }

        System.out.println("수정하거나 삭제할 댓글 번호를 입력하세요 (0: 종료)");

        int commentAction;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                sc.next();
            }
            commentAction = sc.nextInt();
            sc.nextLine();

            if (commentAction == 0) {
                break;
            } else if (commentAction < 1 || commentAction > board.getCommentList().size()) {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            } else {
                CommentDto selectedComment = board.getCommentList().get(commentAction - 1);
                if (selectedComment.getUId().equals(id)) {
                    System.out.println("(1)댓글 수정 (2)댓글 삭제");
                    int action;
                    while (!sc.hasNextInt()) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                        sc.next();
                    }
                    action = sc.nextInt();
                    sc.nextLine();
                    switch (action) {
                        case 1:
                            System.out.println("새 댓글 내용을 입력하세요:");
                            String newContent = sc.nextLine();
                            selectedComment.setContent(newContent);
                            if (BoardDao.updateComment(selectedComment)) {
                                System.out.println("댓글이 수정되었습니다.");
                                showBoardMenu();
                            } else {
                                System.out.println("댓글 수정 실패.");
                            }
                            break;
                        case 2:
                            if (BoardDao.deleteComment(selectedComment.getCommentId(), id)) {
                                System.out.println("댓글이 삭제되었습니다.");
                                showBoardMenu();
                            } else {
                                System.out.println("댓글 삭제 실패.");
                            }
                            break;
                        default:
                            System.out.println("잘못된 선택입니다.");
                            break;
                    }
                } else {
                    System.out.println("작성자가 아닙니다. 다른 댓글을 선택하세요.");
                }
            }
        }

        System.out.println("댓글을 작성 하시겠습니까?? (1)작성 (0)종료 ");
        if (sc.nextInt() == 1) {
            insertComment(board_no);
        }

        if (board.getUId().equals(id)) {
            System.out.println("현재 게시글을 작성한 작성자입니다.");
            System.out.println("(1)현재 글 수정 (2)삭제  (0)종료 ");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("글 수정");
                    updateBoard(board_no);
                    break;
                case 2:
                    System.out.println("글 삭제");
                    deleteBoard(board_no);
                    break;
                default:
                    showBoardMenu();
                    break;
            }
        }
    }


    private void deleteBoard(int board_no) {
        System.out.println(BoardDao.deleteBoard(board_no) ? "삭제 성공" : "삭제 실패");
    }

    private void updateBoard(int board_no) {

        BoardDto board = BoardDao.detailBoard(board_no);
        if (board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }

        System.out.println("현재 제목: " + board.getTitle());
        System.out.print("새 제목을 입력하세요 (변경하지 않으려면 엔터): ");
        String newTitle = sc.nextLine();
        if (newTitle.isEmpty()) {
            newTitle = board.getTitle();
        }

        System.out.println("현재 내용: " + board.getContent());
        System.out.print("새 내용을 입력하세요 (변경하지 않으려면 엔터): ");
        String newContent = sc.nextLine();
        if (newContent.isEmpty()) {
            newContent = board.getContent();
        }

        System.out.print("공지사항 여부 (Y/N, 변경하지 않으려면 엔터): ");
        String newNoticeYn = sc.nextLine();
        if (newNoticeYn.isEmpty()) {
            newNoticeYn = board.getNoticeYn();
        }

        BoardDto updatedBoard = new BoardDto(board_no, newTitle, newContent, id, newNoticeYn, board.getCreatedAt());

        boolean isUpdated = BoardDao.updateBoard(updatedBoard);
        System.out.println(isUpdated ? " 수정 성공" : "수정 실패");
        if (isUpdated) showBoardMenu();
    }
}