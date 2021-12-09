package com.company.netflixcapstone.model;

import java.math.BigDecimal;

public class SalesTaxRate {

    private String state;
    private BigDecimal rate;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesTaxRate)) return false;

        SalesTaxRate that = (SalesTaxRate) o;

        if (!state.equals(that.state)) return false;
        return rate.equals(that.rate);
    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + rate.hashCode();
        return result;
    }
}
