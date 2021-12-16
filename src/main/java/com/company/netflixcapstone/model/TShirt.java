package com.company.netflixcapstone.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {

    private int id;
    @NotEmpty(message = "Size must not be empty")
    @Size(min = 1, max= 20, message = "Size must not exceed 20 characters")
    private String size;
    @NotEmpty(message = "Color must not be empty")
    @Size(min = 1, max= 20, message = "Color must not exceed 20 characters")
    private String color;
    @NotEmpty(message = "Description must not be empty")
    @Size(min = 1, max= 255, message = "Description must not exceed 255 characters")
    private String description;
    @DecimalMin(value= "0.0", message = "Price must be greater or equal to 0.0")
    @Digits(integer= 5, fraction= 2, message = "Price integer part must be 5 digits and Price fractional part must be 2 digits")
    private BigDecimal price;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        if (!(o instanceof TShirt)) return false;

        TShirt tShirt = (TShirt) o;

        if (id != tShirt.id) return false;
        if (quantity != tShirt.quantity) return false;
        if (!size.equals(tShirt.size)) return false;
        if (!color.equals(tShirt.color)) return false;
        if (!description.equals(tShirt.description)) return false;
        return price.equals(tShirt.price);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + size.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + quantity;
        return result;
    }
}
