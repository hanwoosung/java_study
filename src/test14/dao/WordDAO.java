package test14.dao;

import test12.database.DBConn;
import test14.model.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordDAO {
    private static final Connection conn = DBConn.getInstance().getConnection();

    /**
     * <p> 단어를 데이터베이스에 넣기전에 english 중복체크 후 아닐 시 단어 insert</p>
     */
    public void addWord(String english, String korean) {
        String checkSql = "SELECT COUNT(*) FROM word WHERE english = ?";
        String insertSql = "INSERT INTO word  VALUES (?, ?)";

        try (PreparedStatement checkPstmt = conn.prepareStatement(checkSql)) {
            checkPstmt.setString(1, english);
            ResultSet rs = checkPstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("이미 존재하는 단어입니다: " + english);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement insertPstmt = conn.prepareStatement(insertSql)) {
            insertPstmt.setString(1, english);
            insertPstmt.setString(2, korean);
            insertPstmt.executeUpdate();
            System.out.printf("입력한 단어: %s, 단어의 뜻: %s\n", english, korean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Word searchWord(String english) {
        String sql = "SELECT korea FROM word WHERE english = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, english);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Word(rs.getString("korea"), english);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, Word> getAllWords() {
        Map<String, Word> wordMap = new LinkedHashMap<>();
        String sql = "SELECT * FROM word";
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String english = rs.getString("english");
                String korean = rs.getString("korea");
                wordMap.put(english, new Word(korean, english));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wordMap;
    }
}
