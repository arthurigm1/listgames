package com.apijogos.listgames.Service;

import com.apijogos.listgames.Dto.GameListdto;
import com.apijogos.listgames.Dto.GameMindto;
import com.apijogos.listgames.Dto.Gamedto;
import com.apijogos.listgames.Model.Game;
import com.apijogos.listgames.Model.GameList;
import com.apijogos.listgames.Projections.GameMinProjection;
import com.apijogos.listgames.Repository.GameListRepository;
import com.apijogos.listgames.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;



    @Transactional(readOnly = true)
    public Gamedto getGameById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new Gamedto(result);
    }

    @Transactional(readOnly = true)
    public List<GameMindto> findAll() {
        List<Game> result = gameRepository.findAll();
       List<GameMindto> DTO = result.stream().map(x -> new  GameMindto(x)).toList();
       return DTO;
    }
    @Transactional(readOnly = true)
    public List<GameMindto> findgameListbyid(Long id) {
        List<GameMinProjection> result = gameRepository.searchByList(id);
        List<GameMindto> DTO = result.stream().map(x -> new  GameMindto(x)).toList();
        return DTO;
    }

}
