package test9;

import java.sql.SQLException;

public class JDBTUpdate {
    public static void main(String[] args) throws SQLException {

        DBUtils dbUtils = DBUtils.getInstance();
        String query = "UPDATE student SET name = ? where num = ?";
        int result = dbUtils.pUpdate(query, "기기기기", 18);

        System.out.println(result != 0 ? "성공" : "실패");

    }
}