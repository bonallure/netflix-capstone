package com.company.netflixcapstone.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class Invoice {

    private int id;
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 1, max = 80, message = "Name must not exceed 80 characters")
    private String name;
    @NotEmpty(message = "Street must not be empty")
    @Size(min = 1, max = 30, message = "Street must not exceed 30 characters")
    private String street;
    @NotEmpty(message = "City must not be empty")
    @Size(min = 1, max = 30, message = "City must not exceed 30 characters")
    private String city;
    @NotEmpty(message = "State must not be empty")
    @Size(min = 1, max = 30, message = "State must not exceed 30 characters")
    private String state;
    @NotEmpty(message = "Zipcode must not be empty")
    @Size(min = 5, max = 5, message = "Zipcode must only be 5 characters")
    private String zipcode;
    @NotEmpty(message = "Item type must not be empty")
    @Size(min = 1, max = 20, message = "Item type must not exceed 20 characters")
    private String itemType;
    @Min(value = 1, message = "Item id must be greater than or equal to 1")
    private int itemId;
    @DecimalMin(value= "0.0", message = "Unit price must be greater or equal to 0.0")
    @Digits(integer= 5, fraction= 2, message = "Unit price integer part must be 5 digits and Price fractional part must be 2 digits")
    private BigDecimal unitPrice;
    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    private int quantity;
    @DecimalMin(value= "0.0", message = "Sub total must be greater or equal to 0.0")
    @Digits(integer= 11, fraction= 2, message = "Sub total integer part must be 11 digits and Price fractional part must be 2 digits")
    private BigDecimal subtotal;
    @DecimalMin(value= "0.0", message = "Tax must be greater or equal to 0.0")
    @Digits(integer= 5, fraction= 2, message = "Tax integer part must be 5 digits and Price fractional part must be 2 digits")
    private BigDecimal tax;
    @DecimalMin(value= "0.0", message = "Processing fee must be greater or equal to 0.0")
    @Digits(integer= 5, fraction= 2, message = "Processing fee integer part must be 5 digits and Price fractional part must be 2 digits")
    private BigDecimal processingFee;
    @DecimalMin(value= "0.0", message = "Total must be greater or equal to 0.0")
    @Digits(integer= 11, fraction= 2, message = "Total integer part must be 11 digits and Price fractional part must be 2 digits")
    private BigDecimal total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;

        Invoice invoice = (Invoice) o;

        if (id != invoice.id) return false;
        if (itemId != invoice.itemId) return false;
        if (quantity != invoice.quantity) return false;
        if (!name.equals(invoice.name)) return false;
        if (!street.equals(invoice.street)) return false;
        if (!city.equals(invoice.city)) return false;
        if (!state.equals(invoice.state)) return false;
        if (!zipcode.equals(invoice.zipcode)) return false;
        if (!itemType.equals(invoice.itemType)) return false;
        if (!unitPrice.equals(invoice.unitPrice)) return false;
        if (!subtotal.equals(invoice.subtotal)) return false;
        if (!tax.equals(invoice.tax)) return false;
        if (!processingFee.equals(invoice.processingFee)) return false;
        return total.equals(invoice.total);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + zipcode.hashCode();
        result = 31 * result + itemType.hashCode();
        result = 31 * result + itemId;
        result = 31 * result + unitPrice.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + subtotal.hashCode();
        result = 31 * result + tax.hashCode();
        result = 31 * result + processingFee.hashCode();
        result = 31 * result + total.hashCode();
        return result;
    }
}
