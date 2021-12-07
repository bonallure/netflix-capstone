package com.company.netflixcapstone.model;

import java.util.Objects;

public class Console {
    private int console_id;
    private String model;
    private String manufacturer;
    private String memory_amount;
    private String processor;
    private double price;
    private int quantity;

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
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

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        if (!(o instanceof Console)) return false;
        Console consoles = (Console) o;
        return console_id == consoles.console_id && Double.compare(consoles.price, price) == 0 && quantity == consoles.quantity && Objects.equals(model, consoles.model) && Objects.equals(manufacturer, consoles.manufacturer) && Objects.equals(memory_amount, consoles.memory_amount) && Objects.equals(processor, consoles.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(console_id, model, manufacturer, memory_amount, processor, price, quantity);
    }
}
