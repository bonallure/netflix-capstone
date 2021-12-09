package com.company.netflixcapstone.model;

import java.math.BigDecimal;

public class Invoice {

    private int invoiceId;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String itemType;
    private int itemId;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

        if (invoiceId != invoice.invoiceId) return false;
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
        int result = invoiceId;
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
