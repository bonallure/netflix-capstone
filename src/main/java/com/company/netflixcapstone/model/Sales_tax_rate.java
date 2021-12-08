package com.company.netflixcapstone.model;

import java.util.Objects;

public class Sales_tax_rate {
    private char state;
    private double rate;

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sales_tax_rate)) return false;
        Sales_tax_rate that = (Sales_tax_rate) o;
        return state == that.state && Double.compare(that.rate, rate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }
}
