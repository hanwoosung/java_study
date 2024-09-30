package test15.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConn {
    private static DBConn instance;
    private Connection conn;

    private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    private String url;
    private String username;
    private String password;

    private DBConn() {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("src/db.properties");
            properties.load(input);

            this.url = properties.getProperty("db.url");
            this.username = properties.getProperty("db.username");
            this.password = properties.getProperty("db.password");

            Class.forName(DRIVER_NAME);
            this.conn = DriverManager.getConnection(url, username, password);
            System.out.println("드라이버에 연결 되었습니다");
        } catch (ClassNotFoundException | SQLException | IOException e) {
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
