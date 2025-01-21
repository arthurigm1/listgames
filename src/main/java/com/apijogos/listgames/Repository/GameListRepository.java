package com.apijogos.listgames.Repository;


import com.apijogos.listgames.Model.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
