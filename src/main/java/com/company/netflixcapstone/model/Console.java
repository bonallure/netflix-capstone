package com.company.netflixcapstone.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {
    private int id;
    @NotEmpty(message = "Model must not be empty")
    @Size(max = 50, message = "Model must not exceed 50 characters")
    private String model;
    @NotEmpty(message = "Manufacturer must not be empty")
    @Size(max = 50, message = "Manufacturer must not exceed 50 characters")
    private String manufacturer;
    @NotEmpty(message = "Memory amount must not be empty")
    @Size(max = 20, message = "Memory amount must not exceed 20 characters")
    private String memoryAmount;
    @NotEmpty(message = "Processor must not be empty")
    @Size(max = 20, message = "Processor must not exceed 20 characters")
    private String processor;
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
