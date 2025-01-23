package com.apijogos.listgames.Controller;

import com.apijogos.listgames.Dto.GameListdto;
import com.apijogos.listgames.Dto.GameMindto;
import com.apijogos.listgames.Dto.Replacementdto;
import com.apijogos.listgames.Service.GameListService;
import com.apijogos.listgames.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/listgames")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListdto findById(@PathVariable Long id) {
        GameListdto result = gameListService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameListdto> findAll() {
        List<GameListdto> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMindto> findGames(@PathVariable Long listId) {
        List<GameMindto> result = gameService.findgameListbyid(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody Replacementdto body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }


}
