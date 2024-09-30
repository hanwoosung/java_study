package test15;

import test15.database.DBConn;
import test15.dto.myVip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("mVip 테이블 조회");

        select();
    }

    private static void select() {
        Connection conn = DBConn.getInstance().getConnection();
        String sql = "SELECT * FROM myVIP";
        SimpleDateFormat regDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            ArrayList<myVip> myList = new ArrayList<>();

            while (rs.next()) {
                myList.add(new myVip(
                        rs.getString("name"),
                        rs.getString("birth"),
                        rs.getTimestamp("regdate")
                ));
            }

            for (myVip vip : myList) {
                System.out.println("Name: " + vip.getName());

                String birthDateStr = vip.getBirth();
                SimpleDateFormat birthDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = birthDateFormat.parse(birthDateStr);
                System.out.println("Birth Date: " + birthDate);


                System.out.println("Reg Date: " + regDateFormat.format(vip.getRegdate()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }



    private static void insert(String name, String birthDateStr, String regDateStr) {
        String sql = "INSERT INTO myVIP  VALUES (?, ?, ?)";

        SimpleDateFormat birthDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat regDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (Connection conn = DBConn.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);

            Date birthDate = birthDateFormat.parse(birthDateStr);
            ps.setDate(2, new java.sql.Date(birthDate.getTime()));

            Date regDate = regDateFormat.parse(regDateStr);
            ps.setTimestamp(3, new java.sql.Timestamp(regDate.getTime()));

            ps.executeUpdate();
            System.out.println("Insert successful: " + name);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
