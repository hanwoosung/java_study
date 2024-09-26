package test11;

import java.sql.*;
import java.util.ArrayList;

public class QuizDAO {

    static Connection conn = DBConn.getInstance().getConnection();
    static PreparedStatement pstmt = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    //학생 정보 등록
    public static ArrayList<Quiz> select() throws SQLException {
        String sql = "select * from quiz";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        ArrayList<Quiz> quizList = new ArrayList<>();
        while (rs.next()) {
            quizList.add(new Quiz(rs.getInt("num"),rs.getString("content"), rs.getString("answer")));
        }
        return quizList;
    }
}
