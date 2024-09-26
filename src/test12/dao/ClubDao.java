package test12.dao;

import test12.database.DBConn;
import test12.model.request.ClubDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClubDao {

    private static final Connection conn = DBConn.getInstance().getConnection();

    /**
     * 동아리 등록
     */
    public static int clubAdd(ClubDto club) throws SQLException {
        String sql = "INSERT INTO clubtbl VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, club.getClubName());
            pstmt.setString(2, club.getRoomNo());
            return pstmt.executeUpdate();
        }
    }

    /**
     * 모든 동아리 조회
     */
    public static ArrayList<ClubDto> clubSelect() throws SQLException {
        String sql = "SELECT * FROM clubtbl";
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            ArrayList<ClubDto> clubList = new ArrayList<>();
            while (rs.next()) {
                clubList.add(new ClubDto(rs.getString("clubName"), rs.getString("roomNo")));
            }
            return clubList;
        }
    }
}
