package com.apijogos.listgames.Dto;

import com.apijogos.listgames.Model.GameList;

public class GameListdto {

    private Long id;
    private String name;
    public GameListdto() {}

    public GameListdto(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
