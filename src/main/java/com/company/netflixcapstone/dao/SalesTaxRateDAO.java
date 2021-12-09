package com.company.netflixcapstone.dao;

import com.company.netflixcapstone.model.SalesTaxRate;

import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */
public interface SalesTaxRateDAO {

    SalesTaxRate create(SalesTaxRate salesTaxRate);

    SalesTaxRate read(String state);

    List<SalesTaxRate> readAll();

    void update(SalesTaxRate salesTaxRate);

    void delete(String state);
}
