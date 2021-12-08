package com.company.netflixcapstone.model;

import java.util.Objects;

public class Processing_fee {
    private String product_type;
    private double fee;

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processing_fee)) return false;
        Processing_fee that = (Processing_fee) o;
        return Double.compare(that.fee, fee) == 0 && Objects.equals(product_type, that.product_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_type, fee);
    }
}
