package test17.dao;

import test17.dto.ScoreDto;

import java.util.List;

public interface ScoreDao {
    void saveScore(ScoreDto scoreDto);
    List<ScoreDto> getAllScores();
    List<ScoreDto> getUserScores(String username);
}