package com.apijogos.listgames.Repository;

import com.apijogos.listgames.Dto.GameMindto;
import com.apijogos.listgames.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
