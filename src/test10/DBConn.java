package test10;

import test9.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static DBConn instance;
    private Connection conn;

    private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    private static final String URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private DBConn() {
        try {
            Class.forName(DRIVER_NAME);
            this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("드라이버에 연결 되었습니다");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConn getInstance() {
        if (instance == null) {
            instance = new DBConn();
        }
        return instance;
    }
    public Connection getConnection() {
        return this.conn;
    }
}