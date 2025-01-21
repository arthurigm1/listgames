package com.apijogos.listgames.Service;

import com.apijogos.listgames.Dto.GameListdto;
import com.apijogos.listgames.Model.GameList;
import com.apijogos.listgames.Repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;


    @Transactional(readOnly = true)
    public List<GameListdto> findgameList() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListdto> DTO = result.stream().map(x -> new  GameListdto(x)).toList();
        return DTO;
    }


}
