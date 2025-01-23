package com.apijogos.listgames.Service;

import com.apijogos.listgames.Dto.GameListdto;
import com.apijogos.listgames.Model.GameList;
import com.apijogos.listgames.Projections.GameMinProjection;
import com.apijogos.listgames.Repository.GameListRepository;
import com.apijogos.listgames.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

 //transactional e para ter certeza que vai executar em 1 requesrt!
 @Transactional(readOnly = true)
 public List<GameListdto> findAll() {
     List<GameList> result = gameListRepository.findAll();
     return result.stream().map(GameListdto::new).toList();
 }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

    @Transactional(readOnly = true)
    public GameListdto findById(Long id) {
        GameList entity = gameListRepository.findById(id).get();
        return new GameListdto(entity);
    }


}
