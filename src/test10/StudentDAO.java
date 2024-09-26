package test10;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {

    static DBConn conn = DBConn.getInstance();
    static PreparedStatement pstmt = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    //학생 정보 등록
    public static int regist(Student student) throws SQLException {
        String sql = "insert into student values(null,?,?,?,?,?,?,?)";
        pstmt = conn.getConnection().prepareStatement(sql);

        pstmt.setString(1, student.getName());
        pstmt.setInt(2, student.getGrade());
        pstmt.setInt(3, student.getS_class());
        pstmt.setInt(4, student.getSnum());
        pstmt.setInt(5, student.getKorea_socre());
        pstmt.setInt(6, student.getMath_score());
        pstmt.setInt(7, student.getEnglish_score());
        return pstmt.executeUpdate();
    }

    //학생 정보 조회
    public static ResultSet select() throws SQLException {
        String sql = "select * from student";
        stmt = conn.getConnection().createStatement();
        rs = stmt.executeQuery(sql);
        return rs;
    }


    //학생 정보 수정
    public static int update(int num, int check, String value) throws SQLException {
        String column = "";
        switch (check) {
            case 1:
                column = "name";
                break;
            case 2:
                column = "grade";
                break;
            case 3:
                column = "class";
                break;
            case 4:
                column = "snum";
                break;
            case 5:
                column = "korea_score";
                break;
            case 6:
                column = "math_score";
                break;
            case 7:
                column = "english_score";
                break;
        }

        String sql = String.format("UPDATE student SET %s = ? WHERE num = ?", column);
        pstmt = conn.getConnection().prepareStatement(sql);

        if (check == 1) pstmt.setString(1, value);
        else pstmt.setInt(1, Integer.parseInt(value));

        pstmt.setInt(2, num);
        return pstmt.executeUpdate();
    }

    //학생 정보 삭제
    public static int delete(int num) throws SQLException {
        String sql = "DELETE FROM student  WHERE num = ?";
        pstmt = conn.getConnection().prepareStatement(sql);

        pstmt.setInt(1, num);
        return pstmt.executeUpdate();
    }
}
