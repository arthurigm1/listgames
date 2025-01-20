package com.apijogos.listgames.Service;

import com.apijogos.listgames.Dto.GameMindto;
import com.apijogos.listgames.Model.Game;
import com.apijogos.listgames.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMindto> findAll() {
        List<Game> result = gameRepository.findAll();
       List<GameMindto> DTO = result.stream().map(x -> new  GameMindto(x)).toList();
       return DTO;
    }
}
