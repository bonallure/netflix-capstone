package com.company.netflixcapstone.model;

import java.util.Objects;

public class TShirts {
    private int t_shirt_id;
    private String size;
    private String color;
    private String description;
    private double price;
    private int quantity;

    public int getT_shirt_id() {
        return t_shirt_id;
    }

    public void setT_shirt_id(int t_shirt_id) {
        this.t_shirt_id = t_shirt_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TShirts)) return false;
        TShirts tShirts = (TShirts) o;
        return t_shirt_id == tShirts.t_shirt_id && Double.compare(tShirts.price, price) == 0 && quantity == tShirts.quantity && Objects.equals(size, tShirts.size) && Objects.equals(color, tShirts.color) && Objects.equals(description, tShirts.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t_shirt_id, size, color, description, price, quantity);
    }
}
