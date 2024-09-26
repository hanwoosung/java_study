package test12.dao;

import test12.database.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentClubDao {

    private static final Connection conn = DBConn.getInstance().getConnection();

    /**
     * 동아리 가입
     */
    public static int clubJoin(String name, String club) throws SQLException {
        String sql = "INSERT INTO stdclubtbl VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, club);
            return pstmt.executeUpdate();
        }
    }
}