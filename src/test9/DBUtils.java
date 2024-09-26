package test9;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
    private static DBUtils instance;
    private DB conn;
    private Statement stmt;
    private PreparedStatement pstmt;

    private DBUtils(DB db) throws SQLException {
        conn = db;
        stmt = conn.createStatement();
    }

    public static DBUtils getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBUtils(DB.getInstance());
        }
        return instance;
    }

    public int insert(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    public int pInsert(String query) throws SQLException {
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "테스트");
        pstmt.setInt(2, 1);
        pstmt.setInt(3, 1);
        pstmt.setInt(4, 1);
        pstmt.setInt(5, 1);
        pstmt.setInt(6, 1);
        pstmt.setInt(7, 1);

        return pstmt.executeUpdate();
    }

    public int delete(int num) throws SQLException {
        String query = String.format("DELETE FROM student WHERE num =  %d", num);
        return stmt.executeUpdate(query);
    }

    public int pDelete(String query, int num) throws SQLException {
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, num);
        return pstmt.executeUpdate();
    }


    public int update(String newName) throws SQLException {
        String query = String.format("UPDATE student SET name = '%s'", newName);
        return stmt.executeUpdate(query);
    }

    public int pUpdate(String query, String name, int num) throws SQLException {
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setInt(2, num);
        return pstmt.executeUpdate();
    }
}