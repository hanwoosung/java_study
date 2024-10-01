package test17.dao;

import test17.database.DBConn;
import test17.dto.ScoreDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDaoImpl implements ScoreDao {

    Connection conn = DBConn.getInstance().getConnection();

    @Override
    public void saveScore(ScoreDto scoreDto) {

        String checkUserSql = "SELECT score FROM scores WHERE sname = ?";

        try (PreparedStatement checkStmt = conn.prepareStatement(checkUserSql)) {
            checkStmt.setString(1, scoreDto.getSname());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                int currentScore = rs.getInt("score");
                int newScore = currentScore + scoreDto.getScore();

                if (newScore >= 0) {
                    String updateSql = "UPDATE scores SET score = ? WHERE sname = ?";

                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, newScore);
                        updateStmt.setString(2, scoreDto.getSname());
                        updateStmt.executeUpdate();
                    }

                } else {
                    System.out.println("점수가 0보다 작을 수 없습니다.");
                }
            } else {
                if (scoreDto.getScore() > 0) {
                    String insertSql = "INSERT INTO scores (sname, score) VALUES (?, ?)";

                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                        insertStmt.setString(1, scoreDto.getSname());
                        insertStmt.setInt(2, scoreDto.getScore());
                        insertStmt.executeUpdate();
                    }

                } else {
                    System.out.println("점수가 0이면 반영할 수 없습니다.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ScoreDto> getAllScores() {

        List<ScoreDto> scores = new ArrayList<>();
        String sql = """ 
                                SELECT sname, score, RANK() OVER (ORDER BY score DESC) as rank
                                FROM scores 
                """;

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String sname = rs.getString("sname");
                int score = rs.getInt("score");
                int rank = rs.getInt("rank");
                scores.add(new ScoreDto(rank, sname, score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scores;
    }

    @Override
    public List<ScoreDto> getUserScores(String username) {

        List<ScoreDto> scores = new ArrayList<>();
        String sql = "SELECT * FROM scores WHERE sname = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                scores.add(new ScoreDto(rs.getInt("sno"), rs.getString("sname"), rs.getInt("score")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scores;
    }


}
