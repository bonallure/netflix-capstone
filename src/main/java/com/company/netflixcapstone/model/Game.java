package com.company.netflixcapstone.model;

import java.util.Objects;

public class Game {
    private int game_id;
    private String title;
    private String esrb_rating;
    private String description;
    private double price;
    private String studio;
    private int quantity;

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game games = (Game) o;
        return game_id == games.game_id &&
                Double.compare(games.price, price) == 0 &&
                quantity == games.quantity &&
                Objects.equals(title, games.title) &&
                Objects.equals(esrb_rating, games.esrb_rating) &&
                Objects.equals(description, games.description) &&
                Objects.equals(studio, games.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, title, esrb_rating, description, price, studio, quantity);
    }
}
