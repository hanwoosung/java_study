package test9;

import java.sql.*;

public class DB {
    private static DB instance;
    private Connection conn;

    private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://:/";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private DB() {
        try {
            Class.forName(DRIVER_NAME);
            this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("드라이버에 연결 되었습니다");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public Statement createStatement() throws SQLException {
        return conn.createStatement();
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return conn.prepareStatement(query);
    }
}