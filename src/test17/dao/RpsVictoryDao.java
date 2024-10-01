package test17.dao;

import test17.dto.RpsVictoryDto;
import test17.dto.respones.InfoDto;

import java.util.List;

public interface RpsVictoryDao {
    void saveRps(RpsVictoryDto rpsVictoryDto);
    List<InfoDto> getMyInfo(String username);
}
