package test9;

import java.sql.*;

public class JDBCTest {

    public static void main(String[] args) {

        String driverName = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://localhost:3306/mydb";
        String uid = "root";
        String upw = "1234";
        //접속담당
        Connection conn = null;
        //쿼리담당
        Statement stmt = null;
        //조회결과 담당
        ResultSet rs = null;

        try {
            // 1. JDBC 드라이버 로드 (생략가능 - 자바 6버전 이상)
            Class.forName(driverName);



            // 2. 데이터베이스 연결
            conn = DriverManager.getConnection(url, uid, upw);

            if (conn != null) {
                System.out.println("드라이버에 연결 되었습니다");
            }


            // 3. SQL 쿼리 작성 및 실행
            String query = "Select * from student";

            
            stmt = conn.createStatement();

            rs = stmt.executeQuery(query);

            while(rs.next()){
                String name =rs.getString("name");
                int grade =rs.getInt("grade");
            }




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
