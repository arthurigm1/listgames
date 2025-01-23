package com.apijogos.listgames.Controller;

import com.apijogos.listgames.Dto.GameListdto;
import com.apijogos.listgames.Dto.GameMindto;
import com.apijogos.listgames.Dto.Gamedto;
import com.apijogos.listgames.Model.Game;
import com.apijogos.listgames.Repository.GameListRepository;
import com.apijogos.listgames.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;


    @GetMapping(value = "")
    public List<GameMindto> findAll() {
    List<GameMindto> result = gameService.findAll();
    return result;
}
    @GetMapping(value = "/{id}")
    public Gamedto findById(@PathVariable Long id) {
        Gamedto result = gameService.getGameById(id);
        return result;
    }



}
