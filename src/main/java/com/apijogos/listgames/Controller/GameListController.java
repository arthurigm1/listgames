package com.apijogos.listgames.Controller;

import com.apijogos.listgames.Dto.GameListdto;
import com.apijogos.listgames.Dto.GameMindto;
import com.apijogos.listgames.Service.GameListService;
import com.apijogos.listgames.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/listgames")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "")
    public List<GameListdto> findgameList() {
        List<GameListdto> result = gameListService.findgameList();
        return result;
    }

    @GetMapping(value = "{listId}/games")
    public List<GameMindto> findByList(@PathVariable Long listId) {
        List<GameMindto> result = gameService.findgameListbyid(listId);
        return result;
    }


}
