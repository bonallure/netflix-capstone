package com.company.netflixcapstone.dao.impl;

import com.company.netflixcapstone.dao.SalesTaxRateDAO;
import com.company.netflixcapstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */
@Repository
public class SalesTaxRateDAOImpl implements SalesTaxRateDAO {

    // Prepare statements
    private static final String CREATE_PROCESSING_FEE =
            "INSERT INTO sales_tax_rate (state, rate) VALUES (?, ?)";

    public static final String READ_PROCESSING_FEE =
            "SELECT * FROM sales_tax_rate WHERE state = ?";

    public static final String READ_ALL_PROCESSING_FEES =
            "SELECT * FROM sales_tax_rate";

    private static final String UPDATE_PROCESSING_FEE =
            "UPDATE sales_tax_rate SET rate = ? WHERE state = ?";

    private static final String DELETE_PROCESSING_FEE =
            "delete from sales_tax_rate where state = ?";

    // jdbctemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxRateDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SalesTaxRate create(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(CREATE_PROCESSING_FEE,
                salesTaxRate.getState(),
                salesTaxRate.getRate());

        return salesTaxRate;
    }

    @Override
    public SalesTaxRate read(String state) {
        try {
            return jdbcTemplate.queryForObject(READ_PROCESSING_FEE, this::mapToRowSalesTaxRate, state);
        }
        catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public List<SalesTaxRate> readAll() {
        return jdbcTemplate.query(READ_ALL_PROCESSING_FEES, this::mapToRowSalesTaxRate);
    }

    @Override
    public void update(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(UPDATE_PROCESSING_FEE,
                salesTaxRate.getRate(),
                salesTaxRate.getState());
    }

    @Override
    public void delete(String state) {
        jdbcTemplate.update(DELETE_PROCESSING_FEE, state);
    }

    // mapToRowSalesTaxRate
    private SalesTaxRate mapToRowSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));

        return salesTaxRate;
    }
}
