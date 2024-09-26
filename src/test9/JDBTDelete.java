package test9;

import java.sql.SQLException;

public class JDBTDelete {
    public static void main(String[] args) throws SQLException {

//      String query2 = "DELETE FROM student WHERE name = '기환s'";
//      stmt = conn.createStatement();
//      int result = stmt.executeUpdate(query2);

        DBUtils dbUtils = DBUtils.getInstance();
        String query = "DELETE FROM student WHERE num = ?";
        int result = dbUtils.pDelete(query, 17);

        System.out.println(result != 0 ? "성공" : "실패");

    }
}