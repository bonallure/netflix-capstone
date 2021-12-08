package com.company.netflixcapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Console {
    private int id;
    private String model;
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    private BigDecimal price;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        if (!(o instanceof Console)) return false;

        Console console = (Console) o;

        if (id != console.id) return false;
        if (quantity != console.quantity) return false;
        if (!model.equals(console.model)) return false;
        if (!manufacturer.equals(console.manufacturer)) return false;
        if (!memoryAmount.equals(console.memoryAmount)) return false;
        if (!processor.equals(console.processor)) return false;
        return price.equals(console.price);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + model.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + memoryAmount.hashCode();
        result = 31 * result + processor.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + quantity;
        return result;
    }
}
