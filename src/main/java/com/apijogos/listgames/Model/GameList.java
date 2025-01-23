package com.apijogos.listgames.Model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_gamelist")
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public GameList() {}

    public GameList(String name, Long id) {
        this.name = name;
        this.id = id;

    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        GameList gameList = (GameList) object;
        return Objects.equals(id, gameList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
