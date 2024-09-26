package test9;

import java.sql.SQLException;

public class JDBTInsert {
    public static void main(String[] args) throws SQLException {

        DBUtils dbUtils = DBUtils.getInstance();
//      /*  String newName = "가나";
//        int grade = 1;
//        int classs  = 1;
//        int snum= 1;
//        int korea= 1;
//        int math= 1;
//        int english= 1;
//        String query = String.format(
//                "INSERT INTO student VALUES (null, '%s', %d, %d, %d, %d, %d, %d)",
//                newName, grade, classs, snum, korea, math, english
//        );*/

        String query = "INSERT INTO student VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

        int result = dbUtils.pInsert(query);

        System.out.println(result == 1 ? "성공" : "실패");
    }
}