package com.apijogos.listgames.Dto;


import com.apijogos.listgames.Model.Game;
import com.apijogos.listgames.Projections.GameMinProjection;

public class GameMindto {


    private Long id;
    private String title;
    private Integer year;
    private String shortDescription;
    private String imgUrl;


    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public GameMindto(){}

    public GameMindto(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.year = game.getYear();
        this.shortDescription = game.getShortDescription();
        this.imgUrl = game.getImgUrl();
    }

    public GameMindto(GameMinProjection gameMinProjection) {
        this.id = gameMinProjection.getId();
        this.title = gameMinProjection.getTitle();
        this.year = gameMinProjection.getGameYear();
        this.shortDescription = gameMinProjection.getShortDescription();
        this.imgUrl = gameMinProjection.getImgUrl();
    }

}
