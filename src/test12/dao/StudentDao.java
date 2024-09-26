package test12.dao;

import test12.database.DBConn;
import test12.model.request.StudentDto;
import test12.model.respones.StudentClubDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {

    private static final Connection conn = DBConn.getInstance().getConnection();

    /**
     * 학생 등록
     */
    public static int studentAdd(StudentDto student) throws SQLException {
        String sql = "INSERT INTO stdTbl VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getStdName());
            pstmt.setString(2, student.getAddr());
            return pstmt.executeUpdate();
        }
    }

    /**
     * 학생 조회
     */
    public static ArrayList<StudentClubDto> studentSelect() throws SQLException {
        String sql = "SELECT S.stdName, S.addr, SC.clubName, c.roomNo " +
                "FROM stdtbl S " +
                "LEFT OUTER JOIN stdclubtbl SC ON S.stdName = SC.stdName " +
                "LEFT JOIN clubtbl c ON c.clubName = SC.clubName";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            ArrayList<StudentClubDto> stdClubList = new ArrayList<>();
            while (rs.next()) {
                stdClubList.add(new StudentClubDto(
                        rs.getString("stdName"),
                        rs.getString("addr"),
                        rs.getString("clubName") != null ? rs.getString("clubName") : "없음",
                        rs.getString("roomNo") != null ? rs.getString("roomNo") : "없음"
                ));
            }
            return stdClubList;
        }
    }
}
