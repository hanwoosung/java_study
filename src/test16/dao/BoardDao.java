package test16.dao;

import test12.database.DBConn;
import test16.dto.BoardDto;
import test16.dto.CommentDto;

import java.sql.*;
import java.util.ArrayList;
public class BoardDao {
    private static final Connection conn = DBConn.getInstance().getConnection();

    public static ArrayList<BoardDto> getAllWords() {
        String sql = """
                    SELECT b.board_id, b.title, b.content, b.u_id, b.notice_yn, 
                           b.created_at, b.updated_at, (Select count(*) from comment where b.board_id =  board_id) AS comment_count
                    FROM board b
                """;

        ArrayList<BoardDto> boardList = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                BoardDto board = new BoardDto(
                        rs.getLong("board_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("u_id"),
                        rs.getString("notice_yn"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                board.setCommentCount(rs.getInt("comment_count"));
                boardList.add(board);
            }
            return boardList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boardList;
    }


    public static boolean insertBoard(BoardDto board) {

        String sql = "insert into board valu" +
                "es (null,?,?,?,?,?,null)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getContent());
            ps.setString(3, board.getUId());
            ps.setString(4, board.getNoticeYn());
            ps.setTimestamp(5, board.getCreatedAt());
            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static BoardDto detailBoard(int boardNo) {
        String sql = "select * from board  ";
        String commentSql = "select * from comment where board_id=?";
        BoardDto boardDetail = new BoardDto();

        try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setLong(1, boardNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                boardDetail.setBoardId(rs.getInt("board_id"));
                boardDetail.setTitle(rs.getString("title"));
                boardDetail.setContent(rs.getString("content"));
                boardDetail.setUId(rs.getString("u_id"));
                boardDetail.setNoticeYn(rs.getString("notice_yn"));
                boardDetail.setCreatedAt(rs.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("없는 게시글 번호 입니다.");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(commentSql);) {
            pstmt.setLong(1, boardNo);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CommentDto> commentList = new ArrayList<>();
            while (rs.next()) {
                boardDetail.addComment(new CommentDto(rs.getLong("comment_id"),
                        rs.getLong("board_id"),
                        rs.getString("content"),
                        rs.getString("u_id"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("없는 게시글 번호 입니다.");
        }

        return boardDetail;
    }

    public static boolean deleteBoard(int boardNo) {
        String sql = "delete from board where board_id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, boardNo);
            return pstmt.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateBoard(BoardDto board) {
        String sql = "UPDATE board SET title = ?, content = ?, notice_yn = ?, updated_at = ? WHERE board_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getNoticeYn());
            pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            pstmt.setLong(5, board.getBoardId());
            return pstmt.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertComment(CommentDto commentDto) {
        String sql = "insert into comment values (null,?,?,?,?,null)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, commentDto.getBoardId());
            ps.setString(2, commentDto.getContent());
            ps.setString(3, commentDto.getUId());
            ps.setTimestamp(4, commentDto.getCreatedAt());
            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateComment(CommentDto comment) {
        String sql = "UPDATE comment SET content = ?, updated_at = ? WHERE comment_id = ? AND u_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, comment.getContent());
            pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            pstmt.setLong(3, comment.getCommentId());
            pstmt.setString(4, comment.getUId());
            return pstmt.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteComment(long commentId, String userId) {
        String sql = "DELETE FROM comment WHERE comment_id = ? AND u_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, commentId);
            pstmt.setString(2, userId);
            return pstmt.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
