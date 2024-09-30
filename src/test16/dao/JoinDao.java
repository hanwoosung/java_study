package test16.dao;

import test12.database.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDao {
    private static final Connection conn = DBConn.getInstance().getConnection();

    public static boolean join(String id, String name) {
        String checkSql = "SELECT COUNT(*) FROM board_user WHERE u_id = ?";
        String insertSql = "INSERT INTO board_user  VALUES (?, ?,'N')";

        try (PreparedStatement checkPstmt = conn.prepareStatement(checkSql)) {
            checkPstmt.setString(1, id);
            ResultSet rs = checkPstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("이미 존재하는 아이디 입니다: " + id);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement insertPstmt = conn.prepareStatement(insertSql)) {
            insertPstmt.setString(1, id);
            insertPstmt.setString(2, name);

            return insertPstmt.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean login(String id) {
        String checkSql = "SELECT COUNT(*) FROM board_user WHERE u_id = ?";
        try (PreparedStatement checkPstmt = conn.prepareStatement(checkSql)) {
            checkPstmt.setString(1, id);
            ResultSet rs = checkPstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
