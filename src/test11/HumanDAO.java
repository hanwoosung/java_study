package test11;

import test10.Student;

import java.sql.*;

public class HumanDAO {
    static Connection conn = DBConn.getInstance().getConnection();
    static PreparedStatement pstmt = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    //학생 정보 등록
    public static int regist(String  name) throws SQLException {
        String sql = "insert into human values(null,?,null)";
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, name);

        return pstmt.executeUpdate();
    }

    public static int update(int score , String name) throws SQLException {

        String sql = "UPDATE human SET score = IFNULL(score,0) + ? WHERE name = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,score);
        pstmt.setString(2,name);
        return pstmt.executeUpdate();
    }

}
