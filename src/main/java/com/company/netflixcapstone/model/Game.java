package com.company.netflixcapstone.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Game {
    private int id;
    @NotEmpty(message = "Title must not be empty")
    @Size(min = 1, max= 50, message = "Title must not exceed 50 characters")
    private String title;
    @NotEmpty(message= "ESRB rating must not be empty")
    @Size(min = 1, max= 50, message = "ESRB rating must not exceed 50 characters")
    private String esrbRating;
    @NotEmpty(message= "Description must not be empty")
    @Size(min = 1, max= 255, message = "Description must not exceed 255 characters")
    private String description;
    @DecimalMin(value= "0.0", message = "Price must be greater or equal to 0.0")
    @Digits(integer= 5, fraction= 2, message = "Price integer part must be 5 digits and Price fractional part must be 2 digits")
    private BigDecimal price;
    @NotEmpty(message= "Studio must not be empty")
    @Size(min = 1, max= 50, message = "Studio must not exceed 50 characters")
    private String studio;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return getId() == game.getId() && getQuantity() == game.getQuantity() && Objects.equals(getTitle(), game.getTitle()) && Objects.equals(getEsrbRating(), game.getEsrbRating()) && Objects.equals(getDescription(), game.getDescription()) && Objects.equals(getPrice(), game.getPrice()) && Objects.equals(getStudio(), game.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getEsrbRating(), getDescription(), getPrice(), getStudio(), getQuantity());
    }
}
