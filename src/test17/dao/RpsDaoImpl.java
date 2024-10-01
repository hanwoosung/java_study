package test17.dao;

import test17.database.DBConn;
import test17.dto.RpsVictoryDto;
import test17.dto.respones.InfoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RpsDaoImpl implements RpsVictoryDao {
    Connection conn = DBConn.getInstance().getConnection();

    @Override
    public void saveRps(RpsVictoryDto rpsVictoryDto) {
        String sql = """
                INSERT INTO rps_victory
                	(vno, sname, rps, result)
                	VALUES (NULL,?, ?, ?)             
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rpsVictoryDto.getSname());
            ps.setString(2, rpsVictoryDto.getRps());
            ps.setString(3, rpsVictoryDto.getResult());
            System.out.println(ps.executeUpdate() != 0 ? "통계 넣기 성공" : "통계 실패");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<InfoDto> getMyInfo(String username) {
        List<InfoDto> info = new ArrayList<>();
        String sql = """ 
                SELECT sname, pCnt, pWin, pLose, pDraw, sCnt, sWin, sLose, sDraw, rCnt, rWin, rLose, rDraw,
                                SUM(pCnt + sCnt + rCnt) AS allCnt,
                                ROUND(pWin / NULLIF(SUM(pCnt + sCnt + rCnt), 0) * 100, 2) AS pWinPer,
                                ROUND(sWin / NULLIF(SUM(pCnt + sCnt + rCnt), 0) * 100, 2) AS sWinPer,
                                ROUND(rWin / NULLIF(SUM(pCnt + sCnt + rCnt), 0) * 100, 2) AS rWinPer
                                FROM (SELECT s.sname,
                                SUM(IF(b.rps = 'p', 1, 0)) AS pCnt,
                                SUM(IF(b.rps = 'p' AND b.result = 'W', 1, 0)) AS pWin,
                                SUM(IF(b.rps = 'p' AND b.result = 'L', 1, 0)) AS pLose,
                                SUM(IF(b.rps = 'p' AND b.result = 'D', 1, 0)) AS pDraw,
                                SUM(IF(b.rps = 's', 1, 0)) AS sCnt,
                                SUM(IF(b.rps = 's' AND b.result = 'W', 1, 0)) AS sWin,
                                SUM(IF(b.rps = 's' AND b.result = 'L', 1, 0)) AS sLose,
                                SUM(IF(b.rps = 's' AND b.result = 'D', 1, 0)) AS sDraw,
                                SUM(IF(b.rps = 'r', 1, 0)) AS rCnt,
                                SUM(IF(b.rps = 'r' AND b.result = 'W', 1, 0)) AS rWin,
                                SUM(IF(b.rps = 'r' AND b.result = 'L', 1, 0)) AS rLose,
                                SUM(IF(b.rps = 'r' AND b.result = 'D', 1, 0)) AS rDraw
                                FROM scores s
                                LEFT JOIN rps_victory b ON s.sname = b.sname
                                WHERE s.sname = ?
                                GROUP BY s.sname) A
                                GROUP BY sname
                """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                InfoDto dto = new InfoDto();
                dto.setSname(rs.getString("sname"));
                dto.setPCnt(rs.getInt("pCnt"));
                dto.setPWin(rs.getInt("pWin"));
                dto.setPLose(rs.getInt("pLose"));
                dto.setPDraw(rs.getInt("pDraw"));
                dto.setSCnt(rs.getInt("sCnt"));
                dto.setSWins(rs.getInt("sWin"));
                dto.setSLose(rs.getInt("sLose"));
                dto.setSDraw(rs.getInt("sDraw"));
                dto.setRCnt(rs.getInt("rCnt"));
                dto.setRWin(rs.getInt("rWin"));
                dto.setRLose(rs.getInt("rLose"));
                dto.setRDraw(rs.getInt("rDraw"));
                dto.setAllCnt(rs.getInt("allCnt"));
                dto.setPWinPer(rs.getDouble("pWinPer"));
                dto.setSWinsPer(rs.getDouble("sWinPer"));
                dto.setRWinPer(rs.getDouble("rWinPer"));
                info.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return info;
    }

}