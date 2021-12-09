package com.company.netflixcapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {

    private String productType;
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessingFee)) return false;

        ProcessingFee that = (ProcessingFee) o;

        if (!productType.equals(that.productType)) return false;
        return fee.equals(that.fee);
    }

    @Override
    public int hashCode() {
        int result = productType.hashCode();
        result = 31 * result + fee.hashCode();
        return result;
    }
}
